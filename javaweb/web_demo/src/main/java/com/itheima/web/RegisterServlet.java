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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受用户数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //调用MyBatis查询数据库
        //1.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //2.通过SqlSessionFactory获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.通过SqlSession获取Mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.通过Mapper调用方法
        User u = mapper.selectByUsername(username);
        response.setContentType("text/html;charset=utf-8");
        if (u == null) {
            //用户名不存在
            mapper.add(user);
            sqlSession.commit();
            sqlSession.close();
            PrintWriter writer = response.getWriter();
            writer.write("注册成功");
        } else {
            //用户名存在
            PrintWriter writer = response.getWriter();
            writer.write("用户名存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
