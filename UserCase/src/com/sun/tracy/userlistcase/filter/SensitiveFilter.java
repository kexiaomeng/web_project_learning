package com.sun.tracy.userlistcase.filter;

import com.sun.tracy.userlistcase.servelet.AddUserServelet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词过滤器
 */
@WebFilter(value = "/*")
public class SensitiveFilter implements Filter {
    private List<String> sensitiveList = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        // SRC目录下的资源会被tomcat读取到/WEB-INF/classes/目录下
        String filePath = context.getRealPath("/WEB-INF/classes/Sensitive.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = null;
            while((line = reader.readLine()) != null) {
                sensitiveList.add(line);
            }
            System.out.println(sensitiveList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        ServletRequest request = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(),

                (Object proxy, Method method, Object[] args) -> {
                    if("getParameter".equals(method.getName())) {
                        String value = (String)method.invoke(req,args);
                        if (value == null) {
                            return null;
                        }
                        for (String sen : sensitiveList) {
                            if (value.contains(sen)) {
                                value = value.replaceAll(sen,"***");
                            }
                        }
                        return value;
                    }
                    return method.invoke(req, args);
                });
        chain.doFilter(request, resp);
    }


}

