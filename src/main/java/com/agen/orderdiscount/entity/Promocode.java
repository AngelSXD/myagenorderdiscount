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
 * 机构优惠码
 *
 *
 * @author SXD
 * @date 2018/2/2
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class Promocode {


    /**
     * 优惠码ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String codeId;
    /**
     * 优惠码申请时间
     */
    @Column(nullable = false)
    private Date codeDate;

    /**
     * 优惠码
     */
    @Column(nullable = false,length = 500)
    private String promocodeStr;
    /**
     * 优惠折扣率
     */
    @Column(nullable = false)
    private Double promoDiscount;
    /**
     * 机构ID
     */
    @Column(nullable = false)
    private Integer adminId;
    /**
     * 机构名称
     */
    @Column(nullable = false,length = 50)
    private String adminName;
    /**
     * 机构logo
     * 存储图片 base64编码以后的str
     */
    @Column(nullable = false,length = 900000000)
    private String logoImg;
    /**
     * logo文件名字 带后缀
     */
    @Column(nullable = false,length = 200)
    private String fileName;
    /**
     * 优惠备注
     */
    @Column(length = 500)
    private String promoCre;

}

