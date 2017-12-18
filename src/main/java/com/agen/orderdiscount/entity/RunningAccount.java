package com.agen.orderdiscount.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 流水账单
 * @author SXD
 * @date 2017/12/15
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class RunningAccount {

    /**
     * 账单ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String raId;
    /**
     * 流水账单编号
     */
    @Column(nullable = false,length = 100)
    private String raSn;
    /**
     * 流水金额
     */
    @Column(nullable = false,precision = 10,scale = 2)
    private Double raAccount;
    /**
     *流水账时间
     */
    @Column(nullable = false)
    private Date raDate;
    /**
     * 流水状态
     */
    @Column(nullable = false,length = 20)
    private String raStatues;
    /**
     * 操作来源
     */
    @Column(nullable = false,length = 20)
    private String raOperater;

    /**
     * 交易凭证
     * 还未开发 和支付宝微信对接
     * 后期开发 需要设置为nullable = false
     */
    @Column(length = 100)
    private String certificate;
    /**
     * 流水备注
     */
    @Column(length = 500)
    private String ratCre;

    /**
     * 关联子集流水账单
     * 例如：本次提现 涉及到哪些订单，这些订单分别对应哪些可提现的流水
     *
     * mappBy表示关系被维护端，只有关系端有权去更新外键。
     * 这里还有注意OneToMany默认的加载方式是赖加载。当看到设置关系中最后一个单词是Many，那么该加载默认为懒加载
     */
    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},mappedBy = "parentRa",fetch = FetchType.EAGER)
    private List<Available> childAvailables;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="accountType1")
    private AccountType accountType1;

}
