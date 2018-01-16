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
 * 请求提现以后，被记录在流水账单
 * @author SXD
 * @date 2018/1/16
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
     * 流水账单 状态
     * 1    请求提现
     * 2    通过提现请求，提现成功
     * 3    拒绝提现请求，提现失败
     * 4    通过部分提现请求中的订单，拒绝部分提现请求中的订单
     *
     */
    @Column(nullable = false)
    private Integer accountStatus;
    /**
     * 操作来源
     */
    @Column(nullable = false,length = 20)
    private String raOperater;
    /**
     * 流水备注1
     */
    @Column(length = 500)
    private String ratCre1;
    /**
     * 流水备注2
     */
    @Column(length = 500)
    private String ratCre2;

    /**
     * 关联子集流水账单
     * 例如：本次提现 涉及到哪些订单，这些订单分别对应哪些可提现的流水
     *
     * mappBy表示关系被维护端，只有关系端有权去更新外键。
     * 这里还有注意OneToMany默认的加载方式是赖加载。当看到设置关系中最后一个单词是Many，那么该加载默认为懒加载
     */
    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},mappedBy = "parentRa",fetch = FetchType.EAGER)
    private List<AvAmount> childAvamounts;



}
