package com.agen.orderdiscount.repository;

import com.agen.orderdiscount.entity.EsAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * ExAmount 预估金额持久化层
 *
 * @author SXD
 * @date 2018/1/16
 */
public interface EsAmountRepository extends JpaRepository<EsAmount,String>,JpaSpecificationExecutor<EsAmount> {

    EsAmount findEsAmountByAdminIdAndOrderIdAndProductId(Integer adminId,Integer orderId,Integer productId);
}
