package com.waffle.oauth.service;

/**
 * 生成器
 *
 * @author yuexin
 * @since 1.0
 */
public interface Generator<T> {

    /**
     * 生成qi
     *
     * @return
     */
    T generate();
}
