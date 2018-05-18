package com.waffle.component.hbase.beans;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuexin
 */
public class HBaseUtils {

    private static final Logger logger = LoggerFactory.getLogger(HBaseUtils.class);

    private static volatile Map<String, Table> tablesPool = new HashMap<>();

    public static Table getTable(String tableName, Connection connection) {
        if (tablesPool.containsKey(tableName)) {
            return tablesPool.get(tableName);
        }
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            tablesPool.put(tableName, table);
        } catch (Exception e) {
            logger.error("无法创建Table: {}", e);
            table = null;
        }
        return table;
    }

    public static void releaseTable(String tableName, Table table) {
        try {
            table.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTable(Connection connection, String tableName, String... familyNames) {
        HBaseAdmin hBaseAdmin = null;
        try {
            hBaseAdmin = (HBaseAdmin) connection.getAdmin();
            if (hBaseAdmin.tableExists(tableName)) {
                logger.info("HBase 表 {} 已存在!", tableName);
            } else {
                logger.info("开始创建表: {}", tableName);
                HTableDescriptor tableDesc = new HTableDescriptor(TableName.valueOf(tableName));
                for (String familyName : familyNames) {
                    HColumnDescriptor columnDescriptor = new HColumnDescriptor(familyName);
                    tableDesc.addFamily(columnDescriptor);
                }
                hBaseAdmin.createTable(tableDesc);
                logger.info("成功创建表！");
            }
        } catch (Exception e) {
            logger.error("HBase 表 {} 创建失败: {}", tableName, e);
        } finally {
            if (hBaseAdmin != null) {
                try {
                    hBaseAdmin.close();
                } catch (IOException e) {
                    logger.error("关闭HBase流异常");
                }
            }
        }
    }

    public static void dropTable(Connection connection, String tableName) {
        HBaseAdmin admin = null;
        try {
            admin = (HBaseAdmin) connection.getAdmin();
            if (admin.tableExists(tableName)) {
                admin.disableTable(tableName);
                admin.deleteTable(tableName);
            }
        } catch (Exception e) {
            logger.error("HBase 表 {} 创建失败: {}", tableName, e);
        } finally {
            if (admin != null) {
                try {
                    admin.close();
                } catch (IOException e) {
                    logger.error("关闭HBase流异常");
                }
            }

        }
    }
}