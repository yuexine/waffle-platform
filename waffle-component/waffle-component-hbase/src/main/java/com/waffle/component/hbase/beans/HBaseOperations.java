package com.waffle.component.hbase.beans;

import org.apache.hadoop.hbase.client.*;

import java.util.List;


/**
 * @author yuexin
 */
public interface HBaseOperations {

    /**
     * 执行操作
     *
     * @param tableName 表名
     * @param action    业务接口
     * @param <T>       返回
     * @return
     */
    <T> T execute(String tableName, TableCallback<T> action);

    /**
     * 新增一条记录
     *
     * @param tableName 表名
     * @param put       记录
     */
    void put(String tableName, Put put);

    /**
     * 新增多条记录
     *
     * @param tableName 表名
     * @param puts      多条记录
     */
    void put(String tableName, List<Put> puts);

    /**
     * 获取记录
     *
     * @param tableName 表名
     * @param get       条件
     * @return
     */
    Result get(String tableName, Get get);

    /**
     * 扫描表
     *
     * @param tableName 表名
     * @param scan      扫描条件
     * @return
     */
    ResultScanner scan(String tableName, Scan scan);

    /**
     * 删除行
     *
     * @param tableName 表名
     * @param delete    删除条件
     */
    void delete(String tableName, Delete delete);

    /**
     * 对表中的行做原子增操作
     *
     * @param tableName 表名
     * @param increment
     * @return
     */
    Result incrementColumnValue(String tableName, Increment increment);

    /**
     * 创建表
     *
     * @param tableName  表名
     * @param familyName 列族名
     */
    void createTable(String tableName, String familyName);

    /**
     * 删除表
     *
     * @param tableName
     */
    void dropTable(String tableName);

}
