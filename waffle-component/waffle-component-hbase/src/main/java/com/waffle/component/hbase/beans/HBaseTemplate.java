package com.waffle.component.hbase.beans;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author yuexin
 */
public class HBaseTemplate implements HBaseOperations {

    private static final Logger logger = LoggerFactory.getLogger(HBaseTemplate.class);

    private Configuration configuration;

    private Connection connection;

    public HBaseTemplate(Configuration configuration) {
        this.configuration = configuration;
        createConnection();
    }

    private void createConnection() {
        if (null == connection) {
            synchronized (HBaseTemplate.class) {
                if (null == connection) {
                    try {
                        connection = ConnectionFactory.createConnection(configuration);
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error("无法创建HBase链接： {}", e);
                    }
                }
            }
        }
    }

    @Override
    public <T> T execute(String tableName, TableCallback<T> action) {
        Table table = getTable(tableName);
        try {
            boolean previousFlushSetting = applyFlushSetting(table);
            T result = action.doInTable(table);
            flushIfNecessary(table, previousFlushSetting);
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            releaseTable(tableName, table);
        }
    }

    @Override
    public void createTable(String tableName, String familyName) {
        HBaseUtils.createTable(connection, tableName, familyName);
    }

    @Override
    public void dropTable(String tableName) {
        HBaseUtils.dropTable(connection, tableName);
    }

    @Override
    public Result get(String tableName, Get get) {
        return execute(tableName, (table) -> {
            return table.get(get);
        });
    }

    @Override
    public void put(String tableName, Put put) {
        execute(tableName, (table) -> {
            table.put(put);
            return null;
        });
    }

    @Override
    public void put(String tableName, List<Put> puts) {
        execute(tableName, (table -> {
            table.put(puts);
            return null;
        }));
    }

    @Override
    public ResultScanner scan(String tableName, Scan scan) {
        return execute(tableName, (table) -> {
            return table.getScanner(scan);
        });
    }

    @Override
    public void delete(String tableName, Delete delete) {
        execute(tableName, (table) -> {
            table.delete(delete);
            return null;
        });
    }

    @Override
    public Result incrementColumnValue(String tableName, Increment increment) {
        return execute(tableName, (table) -> {
            return table.increment(increment);
        });
    }

    private void flushIfNecessary(Table table, boolean previousFlushSetting) {

    }

    private boolean applyFlushSetting(Table table) {
        //do nothing
        return false;
    }

    private void releaseTable(String tableName, Table table) {
        //do nothing
    }

    private Table getTable(String tableName) {
        return HBaseUtils.getTable(tableName, connection);
    }
}
