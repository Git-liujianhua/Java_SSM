<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>提交参数给Controller</p>

    <form action="receiveproperty.do" method="post">
        姓名：<input type="text" name="name"></pr>
        </br>
        年龄：<input type="text" name="age"></pr>
        </br>
        <input type="submit" value="提交请求数据">
    </form>

    </br>
    <p>from表单请求中的参数名和接受的处理器方法中的形参名不一样的情况</p>
    <form action="receiveparam.do" method="post">
        姓名：<input type="text" name="rname"></pr>
        </br>
        年龄：<input type="text" name="rage"></pr>
        </br>
        <input type="submit" value="提交请求数据">
    </form>

    </br>
    <p>使用Java对象来接收请求参数</p>
    <form action="receiveobject.do" method="post">
        姓名：<input type="text" name="name"></pr>
        </br>
        年龄：<input type="text" name="age"></pr>
        </br>
        <input type="submit" value="提交请求数据">
    </form>

</body>
</html>
