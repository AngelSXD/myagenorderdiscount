package com.agen.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SXD
 * @date 2017/12/04
 * sql server数据库中数据源的 声明装载类
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryMyagen",   //实体管理引用
        transactionManagerRef = "transactionManagerMyagen",                     //事务管理引用
        basePackages = {"com.agen.myagen"})                                    //设置 myagenDataSource应用到的包
public class MyagenDataSourceConfig {

    /**
     * 注入 我的基因网数据源
     */
    @Autowired()
    @Qualifier("myagenDataSource")
    private DataSource myagenDataSource;

    /**
     * 注入JPA配置实体
     */
    @Autowired
    private JpaProperties jpaProperties;

    /**
     * 通过调用JPA配置实体中的解析方法，解析datasource中各属性的值
     * @param dataSource    数据源
     * @return     本数据源中各参数
     * Map中设值分别为：
     *      hibernate-dialect   方言
     *      hibernate.hbm2ddl.auto  DDL执行策略
     *      hibernate.physical_naming_strategy  命名策略
     *
     *这些和不同类型数据库密切相关的属性设置，不能设置在application.properties中，所以需要再不同的数据源中具体设置，赋值给JpaProperties
     */
    private Map<String, String> getVendorProperties(DataSource dataSource) {
        jpaProperties.setDatabase(Database.SQL_SERVER);
        Map<String,String> map = new HashMap<>();
        map.put("hibernate.dialect","org.hibernate.dialect.SQLServer2008Dialect");
        map.put("hibernate.hbm2ddl.auto","update");
        map.put("hibernate.physical_naming_strategy","org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        jpaProperties.setProperties(map);
        return jpaProperties.getHibernateProperties(dataSource);
    }

    /**
     * 配置EntityManagerFactory实体
     *
     * @param builder
     * @return
     * packages     扫描@Entity注释的软件包名称
     * persistenceUnit  持久性单元的名称。 如果只建立一个EntityManagerFactory，你可以省略这个，但是如果在同一个应用程序中有多个，你应该给它们不同的名字
     * properties       标准JPA或供应商特定配置的通用属性。 这些属性覆盖构造函数中提供的任何值。
     */
    @Bean(name = "entityManagerFactoryMyagen")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMyagen(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(myagenDataSource)
                .properties(getVendorProperties(myagenDataSource))
                .packages(new String[]{"com.agen.myagen"})
                .persistenceUnit("myagenPersistenceUnit")
                .build();
    }

    /**
     * 配置EntityManager实体
     *
     * @param builder
     * @return 实体管理器
     */
    @Bean(name = "entityManagerMyagen")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryMyagen(builder).getObject().createEntityManager();
    }


    /**
     * 配置事务
     *
     * @param builder
     * @return 事务管理器
     */
    @Bean(name = "transactionManagerMyagen")
    public PlatformTransactionManager transactionManagerMyagen(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryMyagen(builder).getObject());
    }

}