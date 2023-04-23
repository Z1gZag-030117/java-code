package com.itheima.web.filter; /**
 * @author 朱喆
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest) request;
        String[] urls={"/login.jsp","/css/","/imgs/","loginServlet","register.jsp","registerServlet","checkCodeServlet"};
        String url = req.getRequestURL().toString();
        for (String u : urls) {
            if (url.contains(u)){
                chain.doFilter(request, response);
                return;
            }
        }

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user!=null){
            chain.doFilter(request, response);
        }else {
            req.setAttribute("register_msg","您尚未登录");
            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
