package com.agen.util.threadPool;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Future;

import com.agen.myagen.entity.TBg;
import com.agen.myagen.entity.XxMember;
import com.agen.myagen.entity.XxOrder;
import com.agen.myagen.repository.BgRepository;
import com.agen.myagen.repository.OrderRepository;
import com.agen.orderdiscount.entity.Discount;
import com.agen.orderdiscount.entity.Wallet;
import com.agen.orderdiscount.repository.DiscountRepository;
import com.agen.orderdiscount.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * 线程执行任务类
 */
@Service
public class AsyncTaskService {
    /**
     * 默认构造方法
     */
    Random random = new Random();

    @Resource
    OrderRepository orderRepository;
    @Resource
    BgRepository bgRepository;
    @Resource
    DiscountRepository discountRepository;
    @Resource
    WalletRepository walletRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 无返回值的异步方法
     *
     * 处理MQ队列中取出来的orderId 进行处理
     * @param msg
     */
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void executeAsyncTask(String msg) {
        System.out.println(Thread.currentThread().getName()+"开启新线程执行订单Id:" + msg);
        try {
            Integer orderId = Integer.parseInt(msg);
            XxOrder order =  orderRepository.findOne(orderId);
            if(Objects.nonNull(order)){
                XxMember member = order.getXxMemberByMember();
                TBg bg = bgRepository.findTBgByBgtypeAndMemberIdAndOrderId(1,member.getId(),orderId);
                if(Objects.nonNull(bg)){
                    Integer productId = bg.getProductId();
                    Integer adminId = member.getInstitutions();
                    if(Objects.nonNull(adminId)){
                        Wallet wallet = walletRepository.findWalletByAdminId(adminId);
                        Discount discount = discountRepository.findDiscountByAdminIdAndProductId(adminId,productId);
                        if(Objects.nonNull(discount)){

                            //1.首先操作预估金额记录表


                            //2.对钱包字段金额等进行更改
                            if(Objects.nonNull(wallet)){
                                Double esAmount = wallet.getEsAmount();
                                wallet.setEsAmount(esAmount+discount.getDicountPrice());
                            }else{
                                wallet = new Wallet();
                                wallet.setWalletId(UUID.randomUUID().toString());
                                wallet.setEsAmount(discount.getDicountPrice());
                                wallet.setAvAmount(0D);
                                wallet.setAdminId(adminId);
                            }
                            walletRepository.saveAndFlush(wallet);



                        }
                    }
                }
                //暂未处理，这个地方需要根据订单ID 和memberId获取报告是否创建成功，然后根据报告表中的产品ID 和member中的机构ID,计算出本订单的折扣价钱，进行后续处理
            }

        }catch (Exception e){
            StackTraceElement stackTraceElement = e.getStackTrace()[0];
            String errorMsg = "文件名："+stackTraceElement.getFileName()+
                    "\r\n类名："+stackTraceElement.getClassName()+
                    "\r\n方法名："+stackTraceElement.getMethodName()+
                    "\r\n抛出异常行号："+stackTraceElement.getLineNumber()+
                    "\r\n处理MQ队列取出OrderId处理异常："+e;

            logger.error(errorMsg);
            //若处理失败，则需要对订单ID进行记录，并进行后续的处理，是否需要重新校准订单状态和报告状态 或者做别的事情
        }

    }

    /**
     * 异常调用返回Future
     *
     * 暂时不用
     * @param i
     * @return
     * @throws InterruptedException
     */
    @Async
    public Future<String> asyncInvokeReturnFuture(int i) throws InterruptedException {
        System.out.println("input is " + i);
        Thread.sleep(1000 * random.nextInt(i));
        /**
         * Future接收返回值，这里是String类型，可以指明其他类型
         */
        Future<String> future = new AsyncResult<String>("success:" + i);
        return future;
    }
}
