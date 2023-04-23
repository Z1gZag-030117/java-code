<%--
  Created by IntelliJ IDEA.
  User: zhu zhe
  Date: 2023/2/20
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--    1.<%...%>:内容会直接放到 jspService()方法之中
        2.<%=...%>:内容会放到out.print0中，作为out.print()的参数
        3.<%!...%>:内容会放到jspService()方法之外，被类直接包含
--%>

<h1>hello jsp</h1>
<%
    System.out.println("hello jsp");
    int i = 1;
%>

<%="hello"%>
<%=i%>

<%!
    void show() {
    }

    String name = "zhangsan";
%>

</body>
</html>
