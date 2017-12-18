package com.agen.myagen.repository;

import com.agen.myagen.entity.XxAdmin;
import com.agen.myagen.entity.XxOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository  extends JpaRepository<XxOrder,Integer> {

    List<XxOrder> findTop10ByXxAdminByOperator(XxAdmin xxAdminByOperator);

    @Override
    XxOrder findOne(Integer integer);
}
