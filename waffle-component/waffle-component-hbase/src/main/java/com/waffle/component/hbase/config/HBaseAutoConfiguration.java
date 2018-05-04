package com.waffle.component.hbase.config;

import com.waffle.component.hbase.beans.HBaseTemplate;
import org.apache.hadoop.conf.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

/**
 * @author yuexin
 */
@Order(2)
public class HBaseAutoConfiguration {

    private static final String HBASE_QUORUM = "hbase.zookeeper.quorum";

    @Autowired
    private HBaseProperties hBaseProperties;

    @Bean
    HBaseTemplate hBaseTemplate() {
        return new HBaseTemplate(configuration());
    }

    @Bean
    Configuration configuration() {
        Configuration configuration = new Configuration();
        configuration.set(HBASE_QUORUM, "hdfs://localhost:9000/hbase");
//        configuration.set();
        return configuration;
    }
}
