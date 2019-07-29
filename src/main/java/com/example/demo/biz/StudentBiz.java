package com.example.demo.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IStudentDAO;
import com.example.demo.pojo.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class StudentBiz {
	
	@Resource
	private IStudentDAO dao;
	
	/**
	 * 分页查询学生信息
	 * @param current
	 * @param pageSize
	 * @return
	 */
    public PageInfo<Student> findStudent(Integer current, Integer pageSize){
    	PageHelper.startPage(current, pageSize);
    	return new PageInfo<Student>(dao.findStudent());
    }

}
