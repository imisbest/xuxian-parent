package com.csw.xuxianGategry.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {//前置过滤器，后置过滤器
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {//优先级，数字越小，优先级越大
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 5;
    }

    @Override
    public boolean shouldFilter() {//是否要执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {//过滤器的核心
        System.out.println("进入过滤器");
        return null;
    }
}
