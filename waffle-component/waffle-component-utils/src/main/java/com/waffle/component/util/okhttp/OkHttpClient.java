package com.waffle.component.util.okhttp;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Use OKHttp Pool Client Send Request
 *
 * @author wuyuexin
 */
public class OkHttpClient implements HttpClient {

    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private static final MediaType MEDIA_TYPE_XML = MediaType.parse("text/xml; charset=utf-8");

    private static OkHttpClient client;

    private okhttp3.OkHttpClient okHttpClient;

    /**
     * 内部构造函数
     */
    private OkHttpClient() {
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(128);
        dispatcher.setMaxRequestsPerHost(10);

        builder.dispatcher(dispatcher);
        builder.connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS);
        builder.connectionPool(new ConnectionPool(10, 10, TimeUnit.MINUTES));

        builder.retryOnConnectionFailure(true);

        this.okHttpClient = builder.build();
    }

    /**
     * 获取单例
     *
     * @return
     */
    public static OkHttpClient getInstance() {
        if (client == null) {
            synchronized (OkHttpClient.class) {
                if (client == null) {
                    client = new OkHttpClient();
                }
            }
        }
        return client;
    }

    @Override
    public HttpResponse getSync(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return sync(request);
    }

    @Override
    public void getAsync(String url, HttpResponseListener listener) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        async(request, listener);
    }

    @Override
    public HttpResponse postSync(String url, String json) {
        return postSync(url, json, MEDIA_TYPE_JSON, new Headers.Builder().build());
    }

    @Override
    public HttpResponse postSync(String url, String json, Headers headers) {
        return postSync(url, json, MEDIA_TYPE_JSON, headers);
    }

    @Override
    public HttpResponse postSync(String url, String data, MediaType mediaType, Headers headers) {
        RequestBody body = RequestBody.create(mediaType, data);
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .post(body)
                .build();
        return sync(request);
    }

    @Override
    public void postAsync(String url, String json, HttpResponseListener listener) {
        postAsync(url, json, MEDIA_TYPE_JSON, listener);
    }

    @Override
    public void postAsync(String url, String data, MediaType mediaType, HttpResponseListener listener) {
        RequestBody body = RequestBody.create(mediaType, data);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        async(request, listener);
    }

    /**
     * 同步发送
     *
     * @param request
     * @return
     */
    private HttpResponse sync(Request request) {
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            return parseResponse(response);
        } catch (Throwable t) {
            return new HttpResponse(-1, null, t);
        } finally {
            if (response != null) {
                response.body().close();
            }
        }
    }

    /**
     * 异步发送
     *
     * @param request
     * @param listener
     */
    private void async(Request request, HttpResponseListener listener) {
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFailure(request, new HttpResponse(-1, null, e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final HttpResponse hr = parseResponse(response);
                if (response.isSuccessful()) {
                    listener.onSuccess(request, hr);
                } else {
                    listener.onFailure(request, hr);
                }
            }
        });
    }

    /**
     * 封装okhttp的response
     *
     * @param response
     * @return
     * @throws IOException
     */
    private HttpResponse parseResponse(Response response) throws IOException {
        return new HttpResponse(response.code(), response.body() != null ? response.body().string() : null, null);
    }

}
