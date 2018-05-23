package com.waffle.component.util.okhttp;


/**
 * A wrapper around possible responses from the push gateway.
 *
 * @author wuyuexin
 */
public class HttpResponse {
    private final int httpStatusCode;
    private final String responseBody;
    private final Throwable cause;

    public HttpResponse(int httpStatusCode, String responseBody, Throwable cause) {
        this.httpStatusCode = httpStatusCode;
        this.responseBody = responseBody;
        this.cause = cause;
    }

    /**
     * Returns the throwable from the underlying HttpClient.
     *
     * @return The throwable
     */
    public Throwable getCause() {
        return cause;
    }


    /**
     * Returns the real HTTP status code.
     *
     * @return The HTTP status code
     */
    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    /**
     * Returns the content body (null for a successful response).
     *
     * @return The content body (null for a successful response)
     */
    public String getResponseBody() {
        return responseBody;
    }

    public boolean isSuccessful() {
        return httpStatusCode >= 200 && httpStatusCode < 300;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "httpStatusCode=" + httpStatusCode +
                ", responseBody='" + responseBody + '\'' +
                ", cause=" + cause +
                '}';
    }
}

