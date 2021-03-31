package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;
import com.bjpowernode.vo.QueryParam;
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
    public List<Student> selectMultiParam(@Param("myname") String name,@Param("myage") int age);


    /**
     * 多个参数：使用Java对象作为接口中方法的参数
     * 接口方法中参数的对象类型无限制
     */
    public List<Student> selectMultiObject(QueryParam queryParam);

    public List<Student> selectMultiStudent(Student student);


    /**
     * 多个参数---简单类型的，按位置传值
     * selectMultiPosition
     * mybatis.3.4之前，使用#{0}，#{1}，#{2}
     * mybatis.3.4之后，使用#{arg0}，#{arg1}，#{arg2}
     * 注意：从左到右传递值，从0开始依次递增，注意不要写错了
     */

    public List<Student> selectMultiPosition(String name ,Integer age);

    /**
     * 多个参数，使用map存放多个值
     */
    public List<Student> selectMultiByMap(Map<String,Object> map);

    /**
     * 使用占位符替换列名
     *  selectUse$Order
     */

}
