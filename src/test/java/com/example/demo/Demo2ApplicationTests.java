package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.biz.StudentBiz;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {
	@Autowired
	private StudentBiz biz;

	@Test
	public void contextLoads() {
		
	}

}
