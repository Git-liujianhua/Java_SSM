package com.bjpowernode.dao;

import com.bjpowernode.entity.MyStudent;
import com.bjpowernode.entity.Student;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    /**
     * 一个简单类型的参数：
     *      简单类型：mybatis把Java的基本数据类和String都叫简单类型参数
     *
     *      再mapper文件获取简单类型的一个参数的值，使用的格式是：#{任意字符}-----#{}是占位符
     * @param id
     * @return
     */
    public Student selectStudentById(@Param("id") Integer id);

    /**
     * 多个参数：命名参数，再形参定义的前面加入@Param("自定义参数名称")
     */
    public List<Student> selectMultiParam(@Param("myname") String name,@Param("myage") Integer age);


    public ViewStudent selectStudentReturnViewStudent(@Param("myid") Integer id);

    public int selectCount();

    /**
     * 定义方法返回map
     * @param id
     * @return
     */
    public Map<Object,Object> selectMapById(@Param("myid") Integer id);


    /**
     * 使用resultMap定义映射关系
     */
    public List<Student> selectAllStudents();

    /**
     * 使用resultMap定义映射关系：数据库列名和java对象属性名不一致的情况
     */
    public List<MyStudent> selectAllMyStudents();

    /**
     * selectDiffColProperty
     */
    public List<MyStudent> selectDiffColProperty();

    /**
     * 第一种模糊查询，在Java代码中指定like的内容
     * selectLikeOne
     */
    public List<Student> selectLikeOne(String name);


    /**
     * 第二种模糊查询，在mapper文件中拼接 like内容
     * name就是李值，在mapper中拼接 like "%" 李 "%"
     */
    public List<Student> selectLikeTwo(String name);
}
