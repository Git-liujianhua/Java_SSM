package com.bjpowernode.service.impl;

import com.bjpowernode.dao.OrderDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public int addStudent(Student student) {
        int i = orderDao.insertStudent(student);
        return i;
    }

    @Override
    public List<Student> queryStudent() {
        List<Student> students = orderDao.selectStudents();
        return students;
    }
}
