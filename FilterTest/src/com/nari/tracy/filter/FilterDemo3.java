package com.nari.tracy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/*",dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo3 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("fangwen");
        chain.doFilter(req, resp);
        System.out.println("back-");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
