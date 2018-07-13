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
     * 客户端附加信息
     */
    String CLIENT_ADDITIONAL_INFORMATION = TABLE_PREFIX + "client_additional_information";

    /**
     * 客户端授权类型
     */
    String CLIENT_Grant_TYPE = TABLE_PREFIX + "grant_type";

    /**
     * 客户端重定向URI
     */
    String CLIENT_REDIRECT_URI = TABLE_PREFIX + "redirect_uri";

    /**
     * 客户端域
     */
    String CLIENT_SCOPE = TABLE_PREFIX + "scope";

    /**
     * 资源表
     */
    String RESOURCE = TABLE_PREFIX + "resource";

    /**
     * 客户端归属用户
     */
    String CLIENT_USER = TABLE_PREFIX + "client_user";

    /**
     * 用户基础信息表
     */
    String BASE_USER = TABLE_PREFIX + "base_user";

    /**
     * 系统用户
     */
    String SYS_USER = TABLE_PREFIX + "sys_user";

    /**
     * 角色
     */
    String ROLE = TABLE_PREFIX + "role";
}
