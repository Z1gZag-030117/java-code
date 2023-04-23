package com.itheima.web; /**
 * @author 朱喆
 * @version 1.0
 */

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    //1.调用BrandService完成查询
    private BrandService service=new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //2. 调用selectAll,将查询到的数据存入request中
        List<Brand> brands = service.selectAll();
        request.setAttribute("brands",brands);
        //3.转发到brand,jsp
        request.getRequestDispatcher("/brand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
