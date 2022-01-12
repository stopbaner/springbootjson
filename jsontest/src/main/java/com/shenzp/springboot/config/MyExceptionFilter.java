package com.shenzp.springboot.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

//@Configuration
public class MyExceptionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        throw new MyException("filter异常");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
