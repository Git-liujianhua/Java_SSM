package com.atguigu.spring5.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {

    //数组类型属性
    private String[] courses;
    //List类型属性
    private List<String> lists;
    //Map类型属性
    private Map<String, String> maps;
    //Set类型属性
    private Set<String> sets;
    //在List集合里面设置对象类型的值
    private List<Course> courseList;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "courses=" + Arrays.toString(courses) +
                ", lists=" + lists +
                ", maps=" + maps +
                ", sets=" + sets +
                ",courseList" + courseList +
                '}';
    }

    public void test() {
        System.out.println(Arrays.toString(courses));
        System.out.println(lists);
        System.out.println(maps);
        System.out.println(sets);
        System.out.println(courseList);
    }
}
