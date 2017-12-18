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
 * 表达式
 *
 * 折扣表达式和折扣表后期可以关联，使用灵活的表达式实现不同的机构不同产品的不同使用情况下的折扣
 *
 * 表达式表中的各个变量以及运算符号 来源与 表达式变量实体
 * @author SXD
 * @date 2017/12/15
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class Express {
    /**
     * 表达式ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String expressId;
    /**
     * 折扣表达式
     */
    @Column(nullable = false,length = 500)
    private String expression;
    /**
     * 机构ID
     */
    @Column(nullable = false)
    private Long adminId;
    /**
     * 表达式备注
     */
    @Column(length = 500)
    private String expreCre;

}
