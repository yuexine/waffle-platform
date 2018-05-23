package com.waffle.component.util.okhttp;

import okhttp3.Request;

/**
 * 监听返回
 *
 * @author wuyuexin
 */
public interface HttpResponseListener {

    /**
     * 成功回调
     *
     * @param request
     * @param response
     */
    void onSuccess(Request request, HttpResponse response);

    /**
     * 失败回调
     *
     * @param request
     * @param response
     */
    void onFailure(Request request, HttpResponse response);

}
