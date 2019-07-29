package com.example.demo.dao;

import java.util.List;

import com.example.demo.pojo.Student;

public interface IStudentDAO {
    public int deleteByPrimaryKey(Integer id);

    public int insert(Student record);

    public int insertSelective(Student record);

    public Student selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Student record);

    public int updateByPrimaryKey(Student record);
    
    public List<Student> findStudent();
}