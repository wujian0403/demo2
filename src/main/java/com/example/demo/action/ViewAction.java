package com.example.demo.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.biz.RecordBiz;
import com.example.demo.biz.StudentBiz;

@Controller
@RequestMapping("/c")
public class ViewAction {
	
	@Resource
	private StudentBiz sBiz;
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@GetMapping("login")
	public String toLogin() {
		return "login";
	}
	
	/**
	 * 跳转到主页
	 * @return
	 */
	@GetMapping("welcome")
	public String toIndex() {
		return "welcome";
	}
	
	/**
	 * 新增奖惩信息
	 * @return
	 */
	@GetMapping("add")
	public String toAdd(Model mol) {
		mol.addAttribute("student",sBiz.findStudent(1, 1000));
		return "add";
	}

}
