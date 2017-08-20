package com.dream.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by ning on 2017/8/13.
 */
public class FilterServlet implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String site = filterConfig.getInitParameter("site");
        System.out.println("SITE:"+site);

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie cookie = new Cookie("name", URLEncoder.encode("wang","utf-8"));
        String hello = request.getParameter("hello");
        System.out.println("hellofilter:"+hello);
        request.setAttribute("filter","logFilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}

