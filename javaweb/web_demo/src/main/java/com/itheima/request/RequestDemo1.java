package com.itheima.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author 朱喆
 * @version 1.0
 */
@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求行
        //String getMethod(); 获取请求方式： GET
        String method = req.getMethod();
        System.out.println(method);

        //String getContextPath(); 获取虚拟目录（项目访问路径）：/web_demo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //String Buffer getRequestURL(); 获取URL（统一资源定位符）：http://localhost:8080/web_demo/req1
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());

        //String getRequestURI ();获取URI（统一资源标识符）：/web_demo/req1
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        //String getQueryString ();         获取请求参数（GET）：username=zhangsan&password=123456
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //---------
        //获取请求头 ：user-agent 获取浏览器版本
        String agent = req.getHeader("user-agent");
        System.out.println(agent); //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36 Edg/110.0.1587.41
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post 请求参数

        //1.获取字符输入流
        BufferedReader reader = req.getReader();
        //2.读取数据
        String s = reader.readLine();
        System.out.println(s); //username=zhuzhe&password=123456
    }
}
