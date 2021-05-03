package com.bjpowernode.handler;
import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * @ControllerAdvice:控制器增强（也就是说给控制器类增加功能----异常处理功能）
 *          位置：在类的上面
 * 特点：必须让框架知道这个注解所在的包名，需要在springmvc配置文件中声明组件扫描器
 * 指定@ControllerAdvice所在的包名
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //定义方法，处理发生的异常
    /**
     * 处理异常的方法和控制器方法的定义一样，可以有多个参数，可以有M
     * odelAndView，String，void，对象类型的返回值
     *
     * 形参：Exception，表示Controller中抛出的异常对象。
     * 通过形参可以获取发生的异常信息
     *
     * @ExceptionHandler(异常的class)：表示异常的类型，当发生此类型异常的时候，由当前的方法处理
     */
    @ExceptionHandler(NameException.class)
    public ModelAndView doNameException(Exception ex) {
        //处理NameException的异常
        /**
         * 异常发生的处理逻辑
         * 1、需要把异常记录下来，记录到数据库，日志文件中
         *    记录异常发生的时间，哪个方法发生的，异常的错误内容
         * 2、发送通知，把异常的信息通过邮件，短信，微信等方式发送给相关人员进行及时的处理
         * 3、给用户一个有好的提示
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "姓名必须是zs，其他用户不可用");
        modelAndView.addObject("ex", ex);
        modelAndView.setViewName("nameError");
        return modelAndView;

    }
    //处理AgeException
    @ExceptionHandler(AgeException.class)
    public ModelAndView doAgeException(Exception ex){
        //处理NameException的异常
        /**
         * 异常发生的处理逻辑
         * 1、需要把异常记录下来，记录到数据库，日志文件中
         *    记录异常发生的时间，哪个方法发生的，异常的错误内容
         * 2、发送通知，把异常的信息通过邮件，短信，微信等方式发送给相关人员进行及时的处理
         * 3、给用户一个有好的提示
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","年龄不能大于80也不能为空");
        modelAndView.addObject("ex",ex);
        modelAndView.setViewName("ageError");
        return modelAndView;
    }
    //处理其他异常，NameException，AgeException以外的不知类型的异常
    //处理AgeException
    //这种默认的不知类型的异常，也就是说@ExceptionHandler注解没有参数的异常处理方法只能只能有一个
    @ExceptionHandler
    public ModelAndView doDefaultException(Exception ex){
        //处理NameException的异常
        /**
         * 异常发生的处理逻辑
         * 1、需要把异常记录下来，记录到数据库，日志文件中
         *    记录异常发生的时间，哪个方法发生的，异常的错误内容
         * 2、发送通知，把异常的信息通过邮件，短信，微信等方式发送给相关人员进行及时的处理
         * 3、给用户一个有好的提示
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","年龄不能大于80也不能为空");
        modelAndView.addObject("ex",ex);
        modelAndView.setViewName("defaultError");
        return modelAndView;
    }


}
