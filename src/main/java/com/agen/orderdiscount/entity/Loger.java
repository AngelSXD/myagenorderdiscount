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
 * 日志
 *
 * 记录日志信息  用于回溯+后期拓展日志搜索引擎
 * @author SXD
 * @date 2017/12/18
 */
@Data(staticConstructor = "of")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator" )
public class Loger {

    /**
     * 日志ID
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String loggerId;
    /**
     * 日志标题
     */
    @Column(nullable = false,length = 100)
    private String loggerTitle;
    /**
     * 日志明细
     */
    @Column(columnDefinition = "TEXT",nullable = false,length = 65534)
    private String loggerDetail;
    /**
     * 日志备注
     */
    @Column(length = 500)
    private String loggerCre;
}
