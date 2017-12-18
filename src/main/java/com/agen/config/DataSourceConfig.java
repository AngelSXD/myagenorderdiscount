package com.agen.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author SXD
 * @date 2017/12/04
 * 多数据源装载配置类
 * 数据源的声明
 */
@Configuration
public class DataSourceConfig {

    /**
     * @return  我的基因网数据库
     */
    @Bean(name = "myagenDataSource")
    @Qualifier(value = "myagenDataSource")  //spring装配bean的唯一标识
    @ConfigurationProperties(prefix = "myagen.spring.datasource")   //application.properties配置文件中该数据源的配置前缀
    public DataSource myagenDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     * @return   基因网订单返现数据库
     */
    @Primary    //配置该数据源为主数据源
    @Bean(name = "orderDiscountDataSource")
    @Qualifier(value = "orderDiscountDataSource")
    @ConfigurationProperties(prefix = "orderdiscount.spring.datasource")
    public DataSource orderDiscountDataSource(){
        return DataSourceBuilder.create().build();
    }
}
