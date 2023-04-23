package com.itheima.web; /**
 * @author 朱喆
 * @version 1.0
 */

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调用MyBatis查询数据库
        //1.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //2.通过SqlSessionFactory获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.通过SqlSession获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.通过Mapper调用方法
        User user = mapper.select(username, password);
        //5.释放资源
        sqlSession.close();

        //设置content type
        response.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter writer = response.getWriter();
        //判断user是否为null
        if (user == null) {
            //登录失败
            writer.write("登录失败");
        } else {
            //登录成功
            writer.write("登录成功");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
