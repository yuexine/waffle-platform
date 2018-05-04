package com.waffle.component.hbase.beans;

/**
 * @author yuexin
 */
public interface HBaseOperations {

    <T> T execute(String tableName, TableCallback<T> action);

    void put(String tableName, final String rowName, final String familyName, final String qualifier, final byte[] value);
}
