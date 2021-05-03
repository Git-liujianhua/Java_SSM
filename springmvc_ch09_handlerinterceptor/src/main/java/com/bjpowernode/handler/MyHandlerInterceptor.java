package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 拦截器类：拦截用户的请求
 */
public class MyHandlerInterceptor implements HandlerInterceptor {

    private long btime = 0;

    /**
     * preHandle叫做预处理方法
     * HttpServletRequest request：请求
     * HttpServletResponse response：响应（应答）
     * Object handler：被拦截的控制器对象
     * @return：返回值Boolean
     *      1、true：请求是通过了拦截器的验证，可以执行处理器的方法
     *      ==========1、拦截器的MyHandlerInterceptor的preHandle()========
     *      ==========执行MyController中的doSome()方法======
     *      ==========2、拦截器的MyHandlerInterceptor的postHandle()========
     *      ==========3、拦截器的MyHandlerInterceptor的afterCompletion()========
     *      2、false：请求没有通过拦截器的验证，请求到达拦截器就截止了，请求没有被处理
     *      ==========1、拦截器的MyHandlerInterceptor的preHandle()========
     * 特点：
     *      1、方法在控制器方法（MyController的doSome）之前执行
     *          用户的请求首先到达此方法
     *      2、在这个方法中可以获取请求的信息，验证用户请求是否符合要求。
     *          可以验证用户是否登录，验证用户是否有权限去访问某个链接地址（url）
     *          如果验证失败：可以截断请求，请求不能被处理
     *          如果验证成功：可以放行请求，此时控制器方法才能执行
     *
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        btime = System.currentTimeMillis();
        //计算的业务逻辑，根据计算结果，返回true和false
        System.out.println("==========1、拦截器的MyHandlerInterceptor的preHandle()========");
        return true;
    }

    /**
     * postHandle：后处理方法
     * HttpServletRequest request：请求
     * HttpServletResponse response：响应（应答）
     * Object handler：被拦截的控制器对象
     * ModelAndView modelAndView：处理器方法的返回值
     * 特点：preHandle返回真（true）之后才会执行此方法postHandle
     *      1、在处理器方法之后执行的（MyController.doSome()）
     *      2、能够获取到处理器方法的返回值ModelAndView，可以修改ModelAndView中的数据和视图，可以影响到最后的执行结果。
     *      3、主要是对原来的执行结果做二次修正
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("==========2、拦截器的MyHandlerInterceptor的postHandle()========");
        //对原来的doSome执行结果，需要调整
        if (modelAndView != null){
            //修改数据
            modelAndView.addObject("date",new Date());
            //修改视图
            modelAndView.setViewName("other");
        }
    }

    /**
     * afterCompletion：最后执行的方法
     * HttpServletRequest request：请求
     * HttpServletResponse response：响应（应答）
     * Object handler：被拦截的控制器对象
     * Exception ex：程序中发生的异常
     *
     * 特点：preHandle返回真（true）之后才会执行此方法afterCompletion
     *      1、在请求处理完成后执行的，框架中规定是当你的视图处理完成后，对视图执行了forward。就认为请求处理完成了
     *      2、一般做资源回收的工作的，程序请求过程中创建了的一些对象，在这里可以删除，把占用的内存回收（清空）
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("==========3、拦截器的MyHandlerInterceptor的afterCompletion()========");

        //计算程序从拦截器到controller在到最后的响应程序结束执行的时间
        long etime = System.currentTimeMillis();
        System.out.println("计算从preHandler到afterCompletion程序的执行时间"+(etime-btime));
    }
}
