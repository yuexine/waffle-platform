package com.waffle.component.hbase.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yuexin
 */
@ConfigurationProperties(prefix = "waffle.component.hbase")
public class HBaseProperties {

    private String zookeeperQuorum = "hdfs://localhost:9000/hbase";

    private Integer clientScannerTimeoutPeriod = 50000;

    public String getZookeeperQuorum() {
        return zookeeperQuorum;
    }

    public void setZookeeperQuorum(String zookeeperQuorum) {
        this.zookeeperQuorum = zookeeperQuorum;
    }

    public Integer getClientScannerTimeoutPeriod() {
        return clientScannerTimeoutPeriod;
    }

    public void setClientScannerTimeoutPeriod(Integer clientScannerTimeoutPeriod) {
        this.clientScannerTimeoutPeriod = clientScannerTimeoutPeriod;
    }
}
