<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() +
                      "://" +
                      request.getServerName() +
                      ":" +
                      request.getServerPort() +
                      request.getContextPath() +
                      "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>" >
</head>
<body>
    <div align="center">
        <p>SpringMVC + Spring5 + MyBatis整合案例</p>
        <img src="static/images/SSM.jpg">
        <table>
            <tr>
                <td><a href="addTeacher.jsp">注册学生</a></td>
            </tr>
            <tr>
                <td><a href="listTeacher.jsp">浏览学生</a></td>
            </tr>
        </table>
    </div>
</body>
</html>
