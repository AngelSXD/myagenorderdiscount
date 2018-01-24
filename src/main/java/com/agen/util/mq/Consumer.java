package com.agen.util.mq;


import com.agen.myagen.entity.TBg;
import com.agen.myagen.entity.XxMember;
import com.agen.myagen.entity.XxOrder;
import com.agen.myagen.repository.AdminRepository;
import com.agen.myagen.repository.BgRepository;
import com.agen.myagen.repository.OrderRepository;
import com.agen.orderdiscount.entity.Discount;
import com.agen.orderdiscount.entity.EsAmount;
import com.agen.orderdiscount.entity.Wallet;
import com.agen.orderdiscount.repository.DiscountRepository;
import com.agen.orderdiscount.repository.EsAmountRepository;
import com.agen.orderdiscount.repository.WalletRepository;
import com.agen.util.threadPool.AsyncTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;


/**
 * MQ消息消费者
 *
 * 监听器作用：监听到队列中的orderId之后
 */
@Component
public class Consumer {

    @Resource
    private AsyncTaskService asyncTaskService;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "order.queue")
    public void receive(String orderId){
        System.out.println("MQ取到创建订单的orderID："+orderId);
        /**
         * MQ中取出订单ID后，开启多线程单独进行处理
         */
        asyncTaskService.executeAsyncTask(orderId, AsyncTaskService.Status.create);

    }

    @JmsListener(destination = "orderEnd.queue")
    public void receive2(String orderId){
        System.out.println("MQ取到订单完成的orderID："+orderId);
        /**
         * MQ中取出订单ID后，开启多线程单独进行处理
         */
        asyncTaskService.executeAsyncTask(orderId,AsyncTaskService.Status.end);

    }

}