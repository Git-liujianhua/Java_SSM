<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>我的第一个springmvc</p>
    <%--地址要和后端的Controller中方法上面的RequestMapping中的地址是一样的--%>
    <p><a href="user/some.do">发起some.do请求</a></p>
    <p><a href="user/first.do">发起first.do请求</a></p>
    <form action="user/first.do" method="post">
        <input type="submit" value="发起first.do请求">
    </form>
    <form action="user/other.do" method="post">
        <input type="submit" value="发起other.do请求">
    </form>
    <p><a href="user/second.do">发起second.do请求</a></p>
</body>
</html>
