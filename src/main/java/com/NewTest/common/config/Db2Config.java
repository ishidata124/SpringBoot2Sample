package com.NewTest.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;



/**
 * DB接続設定2(MyBatis)
 *
 * @author john
 */
@Configuration
@ImportResource(value = "classpath:/mybatis-config.xml")
@MapperScan(basePackages = "com.NewTest.myBatisSample.mapper", sqlSessionTemplateRef = "db2SqlSessionTemplate")
public class Db2Config {

}