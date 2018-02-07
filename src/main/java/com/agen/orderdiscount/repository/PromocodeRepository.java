package com.agen.orderdiscount.repository;


import com.agen.orderdiscount.entity.Promocode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * promocode 优惠券持久化层
 *
 * @author SXD
 * @date 2018/2/5
 */
public interface PromocodeRepository extends JpaRepository<Promocode,String>,JpaSpecificationExecutor<Promocode> {

     Promocode findPromocodeByAdminId(Integer adminId);

     /**
      * 根据优惠码字符串  获取优惠券实体
      * @param promocodeStr
      * @return
      */
     Promocode findPromocodeByPromocodeStr(String promocodeStr);

}
