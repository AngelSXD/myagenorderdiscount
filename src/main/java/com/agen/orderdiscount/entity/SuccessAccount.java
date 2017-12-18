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
 * 提现成功流水账单
 *
 * 提现成功之后的流水账单存储到本表中
 * @author SXD
 * @date 2017/12/18
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class SuccessAccount {

    /**
     * 账单ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String suId;
    /**
     * 流水账单编号
     */
    @Column(nullable = false,length = 100)
    private String suSn;
    /**
     * 流水金额
     */
    @Column(nullable = false,precision = 10,scale = 2)
    private Double suAccount;
    /**
     *流水账时间
     */
    @Column(nullable = false)
    private Date suDate;
    /**
     * 流水状态
     */
    @Column(nullable = false,length = 20)
    private String suStatues;
    /**
     * 操作来源
     */
    @Column(nullable = false,length = 20)
    private String suOperater;
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
    private String sutCre;

    /**
     * 关联子集流水账单
     */
    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},mappedBy = "parentSu",fetch = FetchType.EAGER)
    private List<Available> childAvailables;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="accountType2")
    private AccountType accountType2;
}
