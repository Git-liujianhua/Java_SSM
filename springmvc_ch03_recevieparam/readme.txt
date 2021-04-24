springmvc_ch03_recevieparam : 接收请求的参数
接收请求的参数，使用处理器方法的形参
1）HttpServletRequest
2）HttpServletResponse
3）HttpSession
3）用户提交的数据

接收用户提交的参数
1、逐个接收
2、对象接收

注意：
    在提交请求参数时候，get请求方式中文没有乱码
    使用post方式提交请求，中文有乱码，需要使用过滤器处理乱码的问题

过滤器可以自定义，也可以使用框架中提供的过滤器，CharacterEncodingFilter


实现步骤：
1、新建web maven工程

2、加入依赖
    spring-webmvc依赖，间接的把spring的依赖都加入到项目中（因为SpringMVC是基于Spring的所以说Spring的依赖也是都要有的）
    jsp，servlet依赖

3、重点：在web.xml中注册springmvc框架的核心对象DispatcherServlet
    1）DispatcherServlet叫做中央调度器，是一个servlet，它的父类是继承HttpServlet
    2）DispatcherServlet也叫做前端控制器（font controller）
    3）DispatcherServlet负责接收用户提交的请求，调用其他的控制器对象，并把请求的处理结果显示给用户
    只要是SpringMVC项目中央调度器就必须有他是衡量这个项目中用没用SpringMVC的一个标准，有DispatcherServlet这个对象用的就是SpringMVC，没有就不是
    只要是SpringMVC的项目必定要有DispatcherServlet中央调度器对象

4、创建一个发起请求的页面：index.jsp

5、创建控制器(处理起)类
    1）在类的上面加入@Controller注解，创建对象，并放入到SpringMVC容器中
    2）在类中的方法上面加入@RequestMapping注解

6、创建一个作为结果的jsp，显示请求的处理结果

7、创建SpringMVC的配置文件（Spring的配置文件一样）
    1）声明组件扫描器，指的@Controller注解所在的包名
    2）声明视图解析器，帮助处理视图的

SpringMVC项目的实现步骤是和写Servlet差不多的，只是多了第三步DispatcherServlet中央调度器