package com.waffle.component.util.okhttp;

import okhttp3.Headers;
import okhttp3.MediaType;

/**
 * Http Client Tool
 *
 * @author wuyuexin
 */
public interface HttpClient {

    /**
     * 同步get
     *
     * @param url
     * @return
     */
    HttpResponse getSync(String url);

    /**
     * 异步get
     *
     * @param url
     * @param listener
     */
    void getAsync(String url, HttpResponseListener listener);

    /**
     * 同步post
     *
     * @param url
     * @param json
     * @return
     */
    HttpResponse postSync(String url, String json);


    /**
     * 同步post
     *
     * @param url
     * @param data
     * @param headers
     * @return
     */
    HttpResponse postSync(String url, String data, Headers headers);

    /**
     * 同步post
     *
     * @param url
     * @param data
     * @param mediaType
     * @return
     */
    HttpResponse postSync(String url, String data, MediaType mediaType, Headers headers);

    /**
     * 异步post
     *
     * @param url
     * @param json
     * @param listener
     */
    void postAsync(String url, String json, HttpResponseListener listener);

    /**
     * 异步post
     *
     * @param url
     * @param data
     * @param mediaType
     * @param listener
     */
    void postAsync(String url, String data, MediaType mediaType, HttpResponseListener listener);
}
