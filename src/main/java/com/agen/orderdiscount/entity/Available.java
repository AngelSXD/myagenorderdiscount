package com.agen.orderdiscount.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 可提现流水账单
 *
 * 记录订单完成状态 之后 金额从预估金额划分到 可提现金额的流水账单
 * 只有记录到这里的 金额 才能被提取
 * @author SXD
 * @date 2017/12/18
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class Available {

    /**
     * 账单ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String avId;
    /**
     * 流水账单编号
     */
    @Column(nullable = false,length = 100)
    private String avSn;
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
     * 流水金额
     */
    @Column(nullable = false,precision = 10,scale = 2)
    private Double avAccount;
    /**
     *流水账时间
     */
    @Column(nullable = false)
    private Date avDate;
    /**
     * 流水状态
     */
    @Column(nullable = false,length = 20)
    private String avStatues;
    /**
     * 操作来源
     */
    @Column(nullable = false,length = 20)
    private String avOperater;

    /**
     * 流水备注
     */
    @Column(length = 500)
    private String ratCre;

    /**
     * 关联流水账单记录
     *
     * 这里设置JoinColum设置了外键的名字,Available是关系维护端
     */
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="parentRa")
    private RunningAccount parentRa;

    /**
     * 关联提现成功流水账单记录
     *
     * 这里设置JoinColum设置了外键的名字,Available是关系维护端
     */
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="parentSu")
    private SuccessAccount parentSu;

    /**
     * 关联提现失败流水账单记录
     *
     * 这里设置JoinColum设置了外键的名字,Available是关系维护端
     */
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="parentFa")
    private FailAccount parentFa;


}
