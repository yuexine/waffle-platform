package com.waffle.component.hbase.beans;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * @author yuexin
 */
public class HBaseUtils {

    public static Table getTable(String tableName, Configuration configuration) {

        try {
            return new HTable(configuration, tableName.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void releaseTable(String tableName, Table table) {
        try {
            table.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
