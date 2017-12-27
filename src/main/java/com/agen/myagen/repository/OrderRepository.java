package com.agen.myagen.repository;

import com.agen.myagen.entity.XxOrder;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *  Order持久化层
 *
 * @author SXD
 * @date 2017/12/26
 */
public interface OrderRepository  extends JpaRepository<XxOrder,Integer> {

    @Override
    XxOrder findOne(Integer integer);

}
