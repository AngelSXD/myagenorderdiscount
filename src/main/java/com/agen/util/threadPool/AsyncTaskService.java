package com.agen.util.threadPool;

import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Future;

import com.agen.myagen.entity.TBg;
import com.agen.myagen.entity.XxMember;
import com.agen.myagen.entity.XxOrder;
import com.agen.myagen.repository.AdminRepository;
import com.agen.myagen.repository.BgRepository;
import com.agen.myagen.repository.OrderRepository;
import com.agen.orderdiscount.entity.AvAmount;
import com.agen.orderdiscount.entity.Discount;
import com.agen.orderdiscount.entity.EsAmount;
import com.agen.orderdiscount.entity.Wallet;
import com.agen.orderdiscount.repository.AvAmountRepository;
import com.agen.orderdiscount.repository.DiscountRepository;
import com.agen.orderdiscount.repository.EsAmountRepository;
import com.agen.orderdiscount.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    private OrderRepository orderRepository;
    @Resource
    private BgRepository bgRepository;
    @Resource
    private DiscountRepository discountRepository;
    @Resource
    private WalletRepository walletRepository;
    @Resource
    private AdminRepository adminRepository;
    @Resource
    private EsAmountRepository esAmountRepository;
    @Resource
    private AvAmountRepository avAmountRepository;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 枚举类型 默认从0开始
     */
    public enum Status{
        /**
         * 0 创建订单
         */
        create,
        /**
         * 1 完成订单
         */
        end
    }

    /**
     * 无返回值的异步方法
     *
     * 处理MQ队列中取出来的创建订单的orderId 进行处理
     * @param msg
     */
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void executeAsyncTask(String msg,Status status) {
        System.out.println(Thread.currentThread().getName()+"开启新线程执行订单Id:" + msg);
        try {
            Integer orderId = Integer.parseInt(msg);
            XxOrder order =  orderRepository.findOne(orderId);
            if(Objects.nonNull(order)){
                XxMember member = order.getXxMemberByMember();
                TBg bg = bgRepository.findTBgByBgtypeAndMemberIdAndOrderId(1,member.getId(),orderId);
                System.out.println(bg);
                if(Objects.nonNull(bg)){
                    Integer productId = bg.getProductId();
                    Integer adminId = member.getInstitutions();
                    System.out.println("adminId"+adminId);
                    if(Objects.nonNull(adminId)){
                        Wallet wallet = walletRepository.findWalletByAdminId(adminId);
                        Discount discount = discountRepository.findDiscountByAdminIdAndProductId(adminId,productId);
                        if(Objects.nonNull(discount)){
                            //如果是创建订单的处理逻辑
                            if(status == Status.create ){
                                //1.首先操作预估金额记录表
                                EsAmount esAmount = new EsAmount();
                                esAmount.setEsId(UUID.randomUUID().toString());
                                esAmount.setAdminId(adminId);
                                esAmount.setCybId(bg.getCybId());
                                esAmount.setEsAccount(discount.getDicountPrice());
                                esAmount.setEsDate(new Date());
                                esAmount.setEsOperater(adminRepository.findXxAdminById(adminId).getName());
                                esAmount.setMemberId(member.getId());
                                esAmount.setOrderId(orderId);
                                esAmount.setOrderSn(order.getSn());
                                esAmount.setProductId(productId);
                                esAmount.setEsCre1("订单创建成功，预估金额增收");

                                EsAmount esAmount1 = esAmountRepository.save(esAmount);

                                if(Objects.nonNull(esAmount1)){
                                    //2.对钱包字段金额等进行更改
                                    if(Objects.nonNull(wallet)){
                                        Double esAmounts = wallet.getEsAmount();
                                        wallet.setEsAmount(esAmounts+discount.getDicountPrice());
                                    }else{
                                        wallet = new Wallet();
                                        wallet.setWalletId(UUID.randomUUID().toString());
                                        wallet.setEsAmount(discount.getDicountPrice());
                                        wallet.setAvAmount(0D);
                                        wallet.setAdminId(adminId);
                                    }
                                    System.out.println(wallet);
                                    walletRepository.saveAndFlush(wallet);
                                }
                             //如果是 完成订单的处理逻辑
                            }else if(status == Status.end){
                                //1.首先操作可提现金额
                                EsAmount esAmount = esAmountRepository.findEsAmountByAdminIdAndOrderIdAndProductId(adminId,orderId,productId);
                                if(Objects.nonNull(esAmount)){
                                    //1.1 将预估金额扣除到可提现金额的记录也记录到预估金额记录表中
                                    EsAmount esAmount1 = new EsAmount();
                                    BeanUtils.copyProperties(esAmount,esAmount1);
                                    if(Objects.nonNull(esAmount1)){
                                        esAmount1.setEsId(UUID.randomUUID().toString());
                                        esAmount1.setEsDate(new Date());
                                        esAmount1.setEsAccount(-esAmount1.getEsAccount());
                                        esAmount1.setEsCre1("订单完成，预估金额扣除，资金转入可提现金额");

                                        EsAmount esAmount2 = esAmountRepository.save(esAmount1);
                                        if(Objects.nonNull(esAmount2)){
                                            //1.2 记录可提现金额
                                            AvAmount avAmount = new AvAmount();
                                            avAmount.setAvId(UUID.randomUUID().toString());
                                            avAmount.setAdminId(esAmount.getAdminId());
                                            avAmount.setAmountStatus(1);
                                            avAmount.setAvAccount(esAmount.getEsAccount());
                                            avAmount.setAvDate(new Date());
                                            avAmount.setAvOperater(esAmount.getEsOperater());
                                            avAmount.setCybId(esAmount.getCybId());
                                            avAmount.setMemberId(esAmount.getMemberId());
                                            avAmount.setOrderId(esAmount.getOrderId());
                                            avAmount.setOrderSn(esAmount.getOrderSn());
                                            avAmount.setProductId(esAmount.getProductId());

                                            AvAmount avAmount1 = avAmountRepository.save(avAmount);

                                            if(Objects.nonNull(avAmount1)){
                                                //2.对钱包金额进行操作
                                                if(Objects.nonNull(wallet)){
                                                    Double esAmounts = wallet.getEsAmount();
                                                    Double avAmounts = wallet.getAvAmount();
                                                    wallet.setEsAmount(esAmounts - discount.getDicountPrice());
                                                    wallet.setAvAmount(avAmounts + discount.getDicountPrice());

                                                    System.out.println(wallet);
                                                    walletRepository.saveAndFlush(wallet);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
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
