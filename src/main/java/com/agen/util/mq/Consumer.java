package com.agen.util.mq;

import com.agen.myagen.entity.XxMember;
import com.agen.myagen.entity.XxOrder;
import com.agen.myagen.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;


/**
 * MQ消息消费者
 *
 * 监听器作用：监听到队列中的orderId之后
 */
@Component
public class Consumer {

    @Resource
    OrderRepository orderRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "order.queue")
    public void receive(String orderId){
        System.out.println("MQ取到orderID："+orderId);
        Runnable runnable = dealOrder(orderId);
        runnable.run();
    }


    public Runnable dealOrder(String orderId){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                try{
                    Integer orderID = Integer.parseInt(orderId);
                    XxOrder order = orderRepository.findOne(orderID);
                    XxMember member = order.getXxMemberByMember();
                    Objects.nonNull(member);
                }catch (Exception e){
                    System.out.println("订单ID有误");
                    logger.debug("MQ消息队列取出订单ID转化失败\r\n"+e.getMessage());
                }



            }
        };

        return runnable;
    }
}