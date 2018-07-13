package com.waffle.oauth.constant;

/**
 * 数据库表名定义
 *
 * @author yuexin
 */
public interface TableName {

    /**
     * 数据库表前缀
     */
    String TABLE_PREFIX = "";

    /**
     * 客户端概览
     */
    String CLIENT = TABLE_PREFIX + "client";

    /**
     * 客户端详细
     */
    String CLIENT_DETAIL = TABLE_PREFIX + "client_detail";

    /**
     * 客户端归属用户
     */
    String CLIENT_USER = TABLE_PREFIX + "client_user";
}
