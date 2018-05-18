package com.waffle.component.hbase.config;

import com.waffle.component.hbase.beans.HBaseTemplate;
import org.apache.hadoop.conf.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

/**
 * @author yuexin
 */
@Order(2)
public class HBaseAutoConfiguration {

    private static final String HBASE_QUORUM = "hbase.zookeeper.quorum";
    private static final String HBASE_CLIENT_SCANNER_TIMEOUT_PERIOD = "hbase.client.scanner.timeout.period";

    @Bean
    public HBaseProperties hBaseProperties() {
        return new HBaseProperties();
    }

    @Bean
    public HBaseTemplate hBaseTemplate() {
        return new HBaseTemplate(configuration());
    }

    @Bean
    @ConditionalOnMissingBean
    public Configuration configuration() {
        Configuration configuration = new Configuration();
//        configuration.set(HBASE_QUORUM, hBaseProperties().getZookeeperQuorum());
//        configuration.set(HBASE_QUORUM, "hdfs://localhost:9000/hbase");
//        configuration.setInt(HBASE_CLIENT_SCANNER_TIMEOUT_PERIOD, hBaseProperties().getClientScannerTimeoutPeriod());
        return configuration;
    }
}
