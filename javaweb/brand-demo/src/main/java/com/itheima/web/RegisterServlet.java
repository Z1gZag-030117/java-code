package com.itheima.web; /**
 * @author 朱喆
 * @version 1.0
 */

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    UserService service=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        String checkCode = request.getParameter("checkCode");
        HttpSession session = request.getSession();
        String code = (String)session.getAttribute("code");

        if (!code.equalsIgnoreCase(checkCode)){
            request.setAttribute("register_msg","验证码错勿");
            request.getRequestDispatcher("/brand-demo/register.jsp").forward(request,response);
            return;
        }

        boolean flag = service.register(user);

        if (flag){
            request.setAttribute("register_msg","注册成功");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.setAttribute("register_msg"," 用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
