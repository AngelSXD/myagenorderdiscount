package com.agen.orderdiscount.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 预估金额
 * 订单创建成功 往预估金额表中存入记录
 * @author SXD
 * @date 2018/1/16
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class EsAmount {

    /**
     * 预估ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String Id;
    /**
     * 本次转入预估金额
     */
    @Column(nullable = false,precision = 10,scale = 2)
    private Double esAccount;
    /**
     * 本次转入时间
     */
    @Column(nullable = false)
    private Date esDate;
    /**
     * 订单ID
     */
    @Column(nullable = false)
    private Integer orderId;
    /**
     * 订单编号SN
     */
    @Column(nullable = false,length = 20)
    private String orderSn;
    /**
     * 机构ID
     */
    @Column(nullable = false)
    private Integer adminId;
    /**
     * 产品ID
     */
    @Column(nullable = false)
    private Integer productId;
    /**
     * 会员ID
     */
    @Column(nullable = false)
    private Integer memberId;
    /**
     * 采样包ID
     */
    @Column(nullable = false)
    private Integer cybId;
    /**
     * 操作来源
     */
    @Column(nullable = false,length = 20)
    private String esOperater;
    /**
     * 预估金额备注1
     */
    @Column(length = 500)
    private String esCre1;
    /**
     * 预估金额备注2
     */
    @Column(length = 500)
    private String esCre2;






}
