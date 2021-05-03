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
    <base href="<%=basePath%>"/>
</head>
<body>
    <p>当方法返回ModelAndView实现转发操作forward</p>
    <form action="doSome.do" method="post">
        姓名：<input type="text" name="name"><br>
        姓名：<input type="text" name="age"><br>
        <input type="submit" value="提交请求">
    </form>

</body>
</html>
