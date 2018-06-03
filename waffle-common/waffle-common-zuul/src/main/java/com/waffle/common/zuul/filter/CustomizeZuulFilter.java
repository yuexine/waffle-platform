package com.waffle.common.zuul.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * @author yuexin
 */
public class CustomizeZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
