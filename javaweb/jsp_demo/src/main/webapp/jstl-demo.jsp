<%--
  Created by IntelliJ IDEA.
  User: zhu zhe
  Date: 2023/2/20
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
    c:if
--%>
<c:if test="${status==1}">
    <h1>true</h1>
</c:if>

<c:if test="${status==0}">
    <h1>false</h1>
</c:if>


</body>
</html>
