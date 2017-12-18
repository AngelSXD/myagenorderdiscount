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
 * 表达式变量
 *
 * 表达式变量表中
 * 应当存储符号为不变定义量
 * 例如 + - * / % > < >= <= != 和 或 并且 当 等表达固定意义
 *
 * 也要存储自定义量
 * 例如 T 表达天 s 表达秒 M 表达数量等自定义意义
 * @author SXD
 * @date 2017/12/15
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class ExpressVar {

    /**
     * 表达式变量ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String expressVarId;
    /**
     * 变量
     */
    @Column(nullable = false,length = 20)
    private String variable;
    /**
     * 释义
     */
    @Column(nullable = false,length = 200)
    private String interPre;
    /**
     * 表达式变量备注
     */
    @Column(length = 500)
    private String exVarCre;

}
