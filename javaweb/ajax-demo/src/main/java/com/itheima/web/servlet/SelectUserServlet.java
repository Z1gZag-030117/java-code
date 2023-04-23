package com.itheima.web.servlet; /**
 * @author 朱喆
 * @version 1.0
 */

import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectUserServlet")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service=new UserService();
        //接受用户
        String username = request.getParameter("username");

        //调用service查询user

        User user = service.selectByUsername(username);
        boolean flag;
        if (user==null){
            flag=true;
        }else {
            flag=false;
        }

        //响应标记
        response.getWriter().write(""+flag);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
