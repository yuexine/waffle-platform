package com.waffle.oauth.web.model;

/**
 * 包装对象，用于对外提供数据
 *
 * @author yuexin
 */
public interface Wrapper {

    /**
     * 过滤key
     *
     * @param names
     */
    void filter(String... names);

}
