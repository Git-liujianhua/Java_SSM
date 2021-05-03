<%@ page import="org.springframework.web.bind.annotation.RequestParam" %><%--
  Created by IntelliJ IDEA.
  User: 刘峙杰
  Date: 2021/4/2
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>/WEB-INF/views/hello.jsp从request作用域中获取结果</h3>
    <h3>重定向redirect</h3>
    <h3>msg的数据：${param.myname}</h3>
    <h3>fun的数据：${param.myage}</h3>
    <h3>取参数数据相当于:<%=request.getParameter("myname")%></h3>
    <h3>取参数数据相当于:<%=request.getParameter("myage")%></h3>

    <h3>转发forward</h3>
    <h3>msg的数据：${msg}</h3>
    <h3>fun的数据：${fun}</h3>

</body>
</html>
