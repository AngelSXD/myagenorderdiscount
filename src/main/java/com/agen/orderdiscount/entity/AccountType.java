package com.agen.orderdiscount.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * 账单类型
 *
 * 预估转可提现
 *
 * 订单提现账单
 *
 * 提现成功账单
 *
 * 提现失败账单
 *
 *
 * @author SXD
 * @date 2017/12/18
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class AccountType {

    /**
     * 账单类型ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String acId;
    /**
     * 账单类型
     */
    @Column(nullable = false,length = 100)
    private String acType;
    /**
     * 类型备注
     */
    @Column(nullable = false,length = 500)
    private String acCre;

    /**
     * 关联流水账单
     */
    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},mappedBy = "accountType1",fetch = FetchType.EAGER)
    private Set<RunningAccount> runaccounts;

    /**
     * 关联流水账单
     */
    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},mappedBy = "accountType2",fetch = FetchType.EAGER)
    private Set<SuccessAccount> successaccounts;

    /**
     * 关联流水账单
     */
    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},mappedBy = "accountType3",fetch = FetchType.EAGER)
    private Set<FailAccount> failaccounts;
}
