package com.waffle.component.hbase.beans;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;

/**
 * @author yuexin
 */
public class HBaseTemplate implements HBaseOperations {

    private Configuration configuration;

    private volatile boolean autoFlush = true;

    public HBaseTemplate(Configuration configuration) {
        this.configuration = configuration;
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
    public void put(String tableName, String rowName, String familyName, String qualifier, byte[] value) {
        execute(tableName, (table) -> {
            Put put = new Put(rowName.getBytes()).add(familyName.getBytes(), qualifier.getBytes(), value);
            table.put(put);
            return null;
        });
    }

    private void flushIfNecessary(Table table, boolean previousFlushSetting) {

    }

    private boolean applyFlushSetting(Table table) {
        return false;
    }

    private void releaseTable(String tableName, Table table) {
        HBaseUtils.releaseTable(tableName, table);
    }

    private Table getTable(String tableName) {
        return HBaseUtils.getTable(tableName, configuration);
    }
}
