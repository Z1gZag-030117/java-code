package com.itheima.web; /**
 * @author 朱喆
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/bServlet")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取cookie数组
        Cookie[] cookies = request.getCookies();

        //2.遍历数组
        for (Cookie cookie : cookies) {

            String name = cookie.getName();
            if ("username".equals(name)){
                //3.获取cookie数据
                String value = cookie.getValue();
                System.out.println(name+":"+ URLDecoder.decode(value));
                break;
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
