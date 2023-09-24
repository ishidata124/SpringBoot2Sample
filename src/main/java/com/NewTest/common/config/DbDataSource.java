package com.NewTest.common.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * MyBatis設定
 *
 * @author john
 */
@Configuration
@PropertySource("classpath:application.properties")
public class DbDataSource {

    @Autowired
    private Environment env;

    @Bean
    public DataSource db2DataSource() throws Exception {
        // DB情報取得処理
        Map<String, String> dbSettings = this.getDbSettings();

        PoolProperties prop = new PoolProperties();
        // 接続情報
        prop.setUrl(dbSettings.get("url"));
        prop.setUsername(dbSettings.get("username"));
        prop.setPassword(dbSettings.get("password"));
        prop.setDriverClassName(dbSettings.get("driver"));
        // コネクションプール設定
        prop.setInitialSize(20);
        prop.setMaxActive(750);
        prop.setMaxIdle(10);
        prop.setMaxWait(10000);
        // コネクションの検証
        prop.setValidationQuery("SELECT 1");
        prop.setValidationInterval(30000);
        prop.setTestOnBorrow(true);
        prop.setTestOnReturn(false);
        prop.setTestWhileIdle(true);
        prop.setTimeBetweenEvictionRunsMillis(30000);
        prop.setMinEvictableIdleTimeMillis(30000);
        // コミットされずに残ったコネクションは60秒後に破棄
        prop.setRemoveAbandonedTimeout(60);
        prop.setRemoveAbandoned(true);
        prop.setLogAbandoned(true);
        prop.setJmxEnabled(true);
        prop.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource dataSource = new DataSource();
        dataSource.setPoolProperties(prop);
        return dataSource;
    }

    private Map<String, String> getDbSettings() throws Exception {
        Map<String, String> dbSettings = new HashMap<>();

        // application.propertiesから必要な情報を取得
        dbSettings.put("url", env.getProperty("spring.datasource.mybatis.url"));
        dbSettings.put("username", env.getProperty("spring.datasource.mybatis.username"));
        dbSettings.put("password", env.getProperty("spring.datasource.mybatis.password"));
        dbSettings.put("driver", env.getProperty("spring.datasource.mybatis.driverClassName"));

        return dbSettings;
    }
}