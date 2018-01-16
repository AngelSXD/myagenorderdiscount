package com.agen.myagen.repository;

import com.agen.myagen.entity.TBg;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *  Bg持久化层
 *
 * @author SXD
 * @date 2018/1/15
 */
public interface BgRepository extends JpaRepository<TBg,Integer> {

    TBg findTBgByBgtypeAndMemberIdAndOrderId(Integer bgType,Integer memberId,Integer orderId);

}
