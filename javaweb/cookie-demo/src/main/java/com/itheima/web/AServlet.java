package com.itheima.web; /**
 * @author 朱喆
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.创建cookie对象
        String value="朱喆";
        value= URLEncoder.encode(value);
        System.out.println("存储数据"+value);
        Cookie cookie=new Cookie("username",value);
        cookie.setMaxAge(7*24*60*60);

        //2.发送cookie.response
        response.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
