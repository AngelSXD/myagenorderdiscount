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

/**
 * 钱包
 *
 *
 * @author SXD
 * @date 2017/12/15
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class Wallet {

    /**
     * 钱包ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String walletId;
    /**
     * 机构ID
     */
    @Column(nullable = false)
    private Integer adminId;
    /**
     * 预估金额
     */
    @Column(nullable = false,precision = 10,scale = 2)
    private Double esAmount;
    /**
     * 可提现金额
     */
    @Column(nullable = false,precision = 10,scale = 2)
    private Double avAmount;

    /**
     * 钱包备注
     */
    @Column(length = 500)
    private String walletCre;
}
