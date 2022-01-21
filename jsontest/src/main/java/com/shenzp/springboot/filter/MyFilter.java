package com.shenzp.springboot.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "MyFilter", value = "/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("容器启动，filter初始化...");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器未放行。。。");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("过滤器放行。。。");
    }

    @Override
    public void destroy() {
        log.info("容器关闭，MyFilter destroy方法执行。。。");
        Filter.super.destroy();
    }
}
