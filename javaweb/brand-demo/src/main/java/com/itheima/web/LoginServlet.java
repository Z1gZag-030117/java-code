package com.itheima.web; /**
 * @author 朱喆
 * @version 1.0
 */

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user = service.login(username, password);

        if(user!=null){
            if ("1".equals(remember)){
                Cookie cookieUserName=new Cookie("username",username);
                Cookie cookiePassword=new Cookie("password",password);
                cookieUserName.setMaxAge(60*60*24*5);
                cookiePassword.setMaxAge(60*60*24*5);
                response.addCookie(cookieUserName);
                response.addCookie(cookiePassword);
            }
            HttpSession session=request.getSession();
            session.setAttribute("user",user);

            //登录成功,跳转到brandServlet
            //没有数据要传递，使用response.sendRedirect 重定向
            String contextPath = request.getContextPath();
            System.out.println(contextPath);
            response.sendRedirect(contextPath+"/selectAllServlet");

        }else {
            //失败
            //跳转到login页面
            request.setAttribute("login_msg","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
