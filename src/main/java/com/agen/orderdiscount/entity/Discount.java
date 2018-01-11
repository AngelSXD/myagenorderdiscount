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
 * 折扣
 * @author SXD
 * @date 2017/12/15
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class Discount {

    /**
     * 折扣ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String discountId;
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
     * 产品价格
     */
    @Column(nullable = false,precision = 10,scale = 2)
    private Double productPrice;
    /**
     * 产品折扣率
     */
    @Column(precision = 4,scale = 2)
    private Double priceDiscount;
    /**
     * 产品折扣价钱
     */
    @Column(nullable = false,precision = 10,scale = 2)
    private Double dicountPrice;
    /**
     *操作时间
     */
    @Column(nullable = false)
    private Date editDate;
    /**
     * 折扣备注1
     */
    @Column(length = 500)
    private String disCre1;
    /**
     * 折扣备注2
     */
    @Column(length = 500)
    private String disCre2;
    /**
     * 机构名称
     */
    @Column(length = 100)
    private String adminName;
    /**
     * 产品名称
     */
    @Column(length = 100)
    private String productName;


}
