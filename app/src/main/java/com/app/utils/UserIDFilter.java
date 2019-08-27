package com.app.utils;

import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 暂时没用
 */
//@WebFilter(filterName = "UserIDFilter",urlPatterns = "/*")
public class UserIDFilter implements Filter {
    @Resource
    private RestTemplate restTemplate;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session=request.getSession();
        if(session.getAttribute("aliUserId")==null){
            //授权，
            restTemplate.getForObject(AccreditURL.accreditURL(),String.class);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
