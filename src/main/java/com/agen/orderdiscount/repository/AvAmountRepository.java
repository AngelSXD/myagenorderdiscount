package com.agen.orderdiscount.repository;

import com.agen.orderdiscount.entity.AvAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * avAmount 可提现金额持久化层
 *
 * @author SXD
 * @date 2018/1/17
 */
public interface AvAmountRepository extends JpaRepository<AvAmount,String>,JpaSpecificationExecutor<AvAmount> {


}
