package com.waffle.component.hbase.beans;

import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * @author yuexin
 */
@FunctionalInterface
public interface TableCallback<T> {

    /**
     * 在回掉中具体完成功能
     *
     * @param table
     * @return
     * @throws IOException
     */
    T doInTable(Table table) throws IOException;
}
