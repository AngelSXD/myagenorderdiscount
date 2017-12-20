package com.agen.util.mq;


import com.agen.util.threadPool.AsyncTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;



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
        System.out.println("MQ取到orderID："+orderId);
        /**
         * MQ中取出订单ID后，开启多线程单独进行处理
         */
        asyncTaskService.executeAsyncTask(orderId);
    }



}