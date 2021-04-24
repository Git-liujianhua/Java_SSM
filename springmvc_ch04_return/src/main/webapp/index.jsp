<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function (){
            $("button").click(function (){
                // alert("button click");
                $.ajax({
                    // url:"returnVoid-ajax.do",
                    url:"returnStringData.do",
                    data:{
                        name:"张三",
                        age:20
                    },
                    type:"post",
                    //想要获取的是json格式的字符串
                    dataType:"text",
                    success:function (resp){
                        //resp从服务端返回的是json格式的字符串{"name":"zhangsan","age":20}
                        //jquery会把字符串转为json对象，赋值给resp形参
                        //resp代表的就是json字符串的json对象
                        // alert(resp.name + "       " + resp.age);
                        //[{"name":"李四","age":20},{"name":"张三","age":29}]
                        // jQuery的循环函数
                        //i是循环变量，n是数组中的json对象，resp指定的需要循环的数组
                        // $.each(resp,function (i,n){
                        //     alert(n.name + "    " + n.age);
                        // })
                        alert("返回字符串数据" + resp);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>处理器方法返回String表示视图名称(逻辑视图名称)</p>
    <form action="returnString-view.do" method="post">
        姓名：<input type="text" name="name"></pr>
        </br>
        年龄：<input type="text" name="age"></pr>
        </br>
        <input type="submit" value="提交请求数据">
    </form>

    <p>处理器方法返回String表示视图名称(完整路径)</p>
    <form action="returnString-view2.do" method="post">
        姓名：<input type="text" name="name"></pr>
        </br>
        年龄：<input type="text" name="age"></pr>
        </br>
        <input type="submit" value="提交请求数据">
    </form>
    <br/>
    <br/>
    <button id="btn">发起Ajax请求</button>

</body>
</html>
