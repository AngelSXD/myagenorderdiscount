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
 * 操作失败流水账单
 *
 * 操作失败之后的流水账单记录到本表中
 * @author SXD
 * @date 2017/12/18
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class FailAccount {

    /**
     * 账单ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String faId;
    /**
     * 流水账单编号
     */
    @Column(nullable = false,length = 100)
    private String faSn;
    /**
     * 流水金额
     */
    @Column(nullable = false,precision = 10,scale = 2)
    private Double faAccount;
    /**
     *流水账时间
     */
    @Column(nullable = false)
    private Date faDate;
    /**
     * 流水状态
     */
    @Column(nullable = false,length = 20)
    private String faStatues;
    /**
     * 操作来源
     */
    @Column(nullable = false,length = 20)
    private String faOperater;
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
    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},mappedBy = "parentFa",fetch = FetchType.EAGER)
    private List<Available> childAvailables;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="accountType3")
    private AccountType accountType3;
}
