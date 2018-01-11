package com.agen.orderdiscount.repository;


import com.agen.orderdiscount.entity.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * discount 折扣持久化层
 *
 * @author SXD
 * @date 2018/1/8
 */
public interface DiscountRepository extends JpaRepository<Discount,String>{

    /**
     * 根据 adminId 和 productId 查找折扣
     * @param adminId
     * @param productId
     * @return
     */
    Discount findDiscountByAdminIdAndProductId(Integer adminId,Integer productId);

    @Override
    Page<Discount> findAll(Pageable pageable);
}