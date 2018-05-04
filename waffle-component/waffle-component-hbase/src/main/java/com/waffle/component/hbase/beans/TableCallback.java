package com.waffle.component.hbase.beans;

import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * @author yuexin
 */
public interface TableCallback<T> {

    T doInTable(Table table) throws IOException;
}
