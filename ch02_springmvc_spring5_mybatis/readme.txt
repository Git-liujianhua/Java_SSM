ch02_springmvc_spring5_mybatis : SSM整合开发
SSM：SpringMVC + Spring + MyBatis

SpringMVC：视图层、界面层，负责接收请求，显示处理结果的。
Spring：业务层，管理Service，Dao，工具类对象的。
MyBatis：持久层，访问数据库的。

用户发起请求---->SpringMVC接收请求参数---->Spring中的Service对象---->MyBatis处理数据

SSM整合也叫做SSI（IBatis也就是MyBatis的前身），整合中有用到容器
1、第一个容器SpringMVC容器，管理Controller控制器对象的。
2、第二个容器Spring容器，管理Service、Dao、工具类对象
我们要做的就是把使用的对象交给合适的容器创建，管理。把Controller还有web开发的相关的对象交给SpringMVC容器，这个web用的对象写在SpringMVC
配置文件中。

Service、Dao对象定义在Spring的配置文件中，让Spring管理这些对象

SpringMVC容器和Spring容器是有关系的，关系已经确定好了
SpringMVC容器是Spring容器的子容器，类似于java中的继承，单不是继承，只是一个子父容器的关系。（子可以访问父的内容）
在子容器中的Controller可以访问父容器中的Service对象，就可以实现Controller使用Service对象

实现步骤：
0、使用user_db的sqlServer库，表使用t_teacher(id auto_increment,name,age)id是主键
1、新建maven web项目
2、加入依赖
    （1）三个框架的依赖
        1）SpringMVC的依赖
        2）Spring的依赖
        3）MyBatis的依赖
    （2）jackson依赖
    （3）sqlServer驱动（mySql驱动）
    （4）druid连接池依赖
    （5）jsp依赖
    （6）servlet依赖
3、些web.xml
    1）注册DispatcherServlet
        目的：（1）创建springmvc容器对象，才能创建Controller类对象
             （2）创建Servlet，才能接受用户请求
    2）注册spring的监听器：ContextLoaderListener
        目的：创建spring的容器对象，才能创建service，dao等对象
    3）注册字符集过滤器，结局post请求乱码的问题
4、创建包：Controller包、Service包、Dao包、实体类包名创建好
    1）Controller包
    2）Service包
    3）Dao包
    4）实体类包
5、写SpringMVC、Spring、myBatis的配置文件
    1）SpringMVC配置文件
    2）Spring配置文件
    3）myBatis配置文件
    4）数据库的属性配置文件
6、写代码
    1）dao接口和mapper的xml文件
    2）service接口和service实现类
    3）controller
    4）实体类
7、写jsp页面