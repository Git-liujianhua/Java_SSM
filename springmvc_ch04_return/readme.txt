springmvc_ch04_return：处理器方法的返回值表示请求的处理结果
1、ModelAndView：有数据和视图，对视图执行forward
2、String：表示视图，可以是逻辑名称，也可以是完整视图路径
3、Void：不能表示数据，也不能表示视图。（本身没有什么用处）
    在处理Ajax的时候，可以使用Void返回值的。通过HttpServletResponse输出数据，响应Ajax请求。
    Ajax请求服务器端返回的就是数据，和视图无关。
4、Object：例如String、Integer、Map、List、Student等等都是对象。
    对象有属性，属性就是数据。所以返回Object表示数据，和视图无关
    可以使用对象表示的数据，响应Ajax请求。

    现在做ajax，主要使用json的数据格式。实现步骤：
    （
        面试题：springmvc的处理器方法返回的是json怎么来实现它
          1、加入处理json的工具库的依赖，springmvc默认使用的是jackson
          2、在springmvc配置文件中加入<mvc:annotation-driven>注解驱动
          3、在处理器方法的上面加入@ResponseBody注解
    ）
        1）加入处理json的工具库的依赖，springmvc默认使用的是jackson。
        2）在springmvc配置文件中加入<mvc:annotation-driven>注解驱动。
            json = objectMapper.writeValueAsString(student);
        3）在处理器方法的上面加入@ResponseBody注解
            //告诉浏览器响应的是json格式的数据
            response.setContentType("application/json;charset=utf-8");
            //根据getWriter()获取一个PrintWriter对象
            PrintWriter writer = response.getWriter();
    springmvc处理器方法返回Object，可以转换为json输出到浏览器，响应ajax的内部原理
    1、<mvc:annotation-driven> 注解驱动（会创建7个HttpMessageConverter接口的实现类对象）
        注解驱动实现的功能是 完成Java对象到json、xml、text、二进制等数据格式的转换
        <mvc:annotation-driven>在加入到springmvc配置文件后，会自动创建HttpMessageConverter接口：消息转换器
        的7个实现类对象，包括 MappingJackson2HttpMessageConverter （使用jackson工具库中的ObjectMapper实习Java对象转为json字符串）
        它完成了就可以实现Java对象转json字符串了

        注解驱动<mvc:annotation-driven>所涉及到的接口：HttpMessageConverter接口：消息转换器。
        功能：定义了Java转换为json、xml、text、二进制等数据格式的方法。这个接口有很多的实现类
             这些实现类完成了 Java对象到json、Java对象到xml、Java对象到二进制数据的转换。

    下面的两个方法是控制器类把结果输出给浏览器时使用的：
    boolean canWrite(Class<?> var1, @Nullable MediaType var2);
    void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3)

    例如：处理器方法。
    @RequestMapping(value = "/returnVoid-ajax.do")
    public Student doReturnVoidAjax(HttpServletResponse response,String name,Integer age) throws IOException {
        System.out.println("=====doReturnView2======" + name + ":" + age);
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }
    1）canWrite作用：检查处理器方法的返回值，能不能转为var2表示的数据格式
        检查student("lisi",10);能不能转为var2表示的数据格式。如果检查能转为某种格式，例如json，canWrite返回true
        转换操作默认是先去转换json格式的字符串的
        （var2表示的格式有很多种，框架会尝试转成不同的格式，看最终转换成哪一种格式，例如：如果框架转换成json格式的字符串成功后，其他的转换格式就不检查了）
        MediaType：是表示数据格式的，例如json、xml等等

    2）write：把处理器方法的返回值对象，调用jackson中的ObjectMapper转换为json字符串。
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(student);

2、@ResponseBody注解
    放在处理器方法的上面，通过HttpServletResponse输出数据，响应ajax请求的
        //根据getWriter()获取一个PrintWriter对象
        PrintWriter writer = response.getWriter();
        //输出数据
        writer.print(json);
        //刷新缓存
        writer.flush();
        //关闭PrintWriter
        writer.close();

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