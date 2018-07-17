package com.waffle.oauth.web.wrapper;

/**
 * 包装对象，用于对外提供数据
 *
 * @author yuexin
 */
public interface Wrapper {

    /**
     * 过滤字段返回
     *
     * @param names 过滤的字段名
     */
    void filter(String... names);

}
