package com.example.demo.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IRecordDAO;
import com.example.demo.pojo.Record;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class RecordBiz {
	
	@Resource
	private IRecordDAO dao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public int insert(Record record) {
    	return dao.insert(record);
    }

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
    public int updateByPrimaryKey(Record record) {
    	return dao.updateByPrimaryKey(record);
    }

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}
	
    public Record selectByPrimaryKey(Integer id) {
    	return dao.selectByPrimaryKey(id);
    }
	
    public List<Record> findRecordByStudent(String code){
    	return dao.findRecordByStudent(code);
    }

    public PageInfo<Record> findRecordAll(String code,String stu,Integer current,Integer pageSize){
    	PageHelper.startPage(current, pageSize);
    	return new PageInfo<Record>(dao.findRecordAll(code,stu));
    }
}
