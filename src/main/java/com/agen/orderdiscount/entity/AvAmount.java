package com.agen.orderdiscount.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 可提现金额
 * 报告完成，订单完结 从预估金额存入可提现金额
 * @author SXD
 * @date 2018/1/16
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class AvAmount {

    /**
     * 可提现ID
     */
    @javax.persistence.Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String Id;
    /**
     * 本次转入可提现金额
     */
    @Column(nullable = false,precision = 10,scale = 2)
    private Double avAccount;
    /**
     * 本条可提现金额记录 状态
     * 1    可提现
     * 2    请求提现，正在等待处理
     * 3    已经成功转账，提现成功
     * 4    不满足提现条件，被拒绝提现请求的
     *
     */
    @Column(nullable = false)
    private Integer amountStatus;
    /**
     * 本次转入时间
     */
    @Column(nullable = false)
    private Date avDate;
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
    private String avOperater;
    /**
     * 可提现金额备注1
     */
    @Column(length = 500)
    private String avCre1;
    /**
     * 可提现金额备注2
     */
    @Column(length = 500)
    private String avCre2;

    /**
     * 关联流水账单记录
     *
     * 这里设置JoinColum设置了外键的名字,Available是关系维护端
     */
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="parentRa")
    private RunningAccount parentRa;

}
