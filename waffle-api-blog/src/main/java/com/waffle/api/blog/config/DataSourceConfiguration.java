package com.waffle.api.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author yuexin
 */
@Configuration
public class DataSourceConfiguration {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(applicationProperties.getDataSource().getUrl());
        ds.setUsername(applicationProperties.getDataSource().getUsername());
        ds.setPassword(applicationProperties.getDataSource().getPassword());
        ds.setDriverClassName(applicationProperties.getDataSource().getDriverClass());
        return ds;
    }
}
