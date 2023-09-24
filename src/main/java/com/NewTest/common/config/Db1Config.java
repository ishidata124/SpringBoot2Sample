package com.NewTest.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * DB接続設定1(JPA)
 *
 * @author john
 */
@Configuration
@EnableJpaRepositories(basePackages = { "com.NewTest.jpaSample.repository"},
        entityManagerFactoryRef = "primaryEntityManager",
        transactionManagerRef = "primaryTransactionManager")
public class Db1Config {

    @Bean
    // メインにPrimaryをつける
    @Primary
    // プロパティのプレフィックス
    @ConfigurationProperties(prefix = "spring.datasource.jpa")
    public DataSourceProperties primaryProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @Autowired
    public DataSource primaryDataSource(@Qualifier("primaryProperties")
                                        DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    @Autowired
    public LocalContainerEntityManagerFactoryBean primaryEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("primaryDataSource") DataSource dataSource){
        return builder.dataSource(dataSource)
                // エンティティのパッケージ
                .packages("com.NewTest.jpaSample.entity")
                .persistenceUnit("primary")
                .build();
    }

    @Bean
    @Primary
    @Autowired
    public JpaTransactionManager primaryTransactionManager(@Qualifier("primaryEntityManager") LocalContainerEntityManagerFactoryBean primaryEntityManager) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(primaryEntityManager.getObject());
        return transactionManager;
    }
}