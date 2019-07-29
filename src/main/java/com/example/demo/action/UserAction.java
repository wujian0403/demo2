package com.example.demo.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.RecordBiz;
import com.example.demo.biz.StudentBiz;
import com.example.demo.pojo.Record;


@Controller
@RequestMapping("api")
public class UserAction {
	
	@Resource
	private StudentBiz sBiz;
	
	@Resource
	private RecordBiz rBiz;

	/**
	 * 登录
	 * @param model
	 * @param name
	 * @param pwd
	 * @param session
	 * @return
	 */
	@GetMapping("loginIn")
	public String validateUsersInfo(Model model, String name, String pwd, HttpSession session) {
		if("admin".equals(name)&&"123".equals(pwd)) {
			session.setAttribute("USER",name);
			return "redirect:/c/welcome";
		}else {
			model.addAttribute("MSG", "用户名或密码错误");
			return "login";//必须是模板文件名【转发】
		}
	}
	
	/**
	 * 分页查询学生信息
	 * @param current
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/stuList")
	public String findStudentList(Integer current, Integer pageSize,Model model){
		if(current.equals("") || current == 0) {
			current = 1;
		}
		if(pageSize.equals("") || pageSize == 0) {
			pageSize = 5;
		}
		model.addAttribute("PAGE_INFO",sBiz.findStudent(current, pageSize));
		return "stuList";
	}
	
	/**
	 * 查询当前学生的具体奖惩信息
	 * @param code
	 * @return
	 */
	@ResponseBody
	@PostMapping("/stuReAndPu")
	public List<Record> findStudentRewardAndPublishment(String code){
		return rBiz.findRecordByStudent(code);
	}
	
	/**
	 * 查询当前学生的具体奖惩信息
	 * @param code
	 * @return
	 */
	@GetMapping("/stu/{codes}/{stu}/{current}/{pageSize}")
	public String findRewardAndPublishment(@PathVariable String codes,@PathVariable String stu,@PathVariable Integer current,@PathVariable Integer pageSize, Model mol){
//		if(current.equals("") || current == null) {
//			current = 1;
//		}
//		if(pageSize.equals("") || pageSize == null) {
//			pageSize = 5;
//		}
		mol.addAttribute("stuRe", rBiz.findRecordAll(codes,stu,current,pageSize));
		return "reAndPu";
	}
	
	/**
	 * 新增奖惩记录
	 * @param record
	 * @return
	 */
	@PostMapping("add")
	public String addReward(Record record,HttpSession session) {
		record.setCreateby((String)session.getAttribute("USER"));
		Integer count = rBiz.insert(record);
		if(count > 0) {
//			map.put("code", "200");
//			map.put("msg", "新增成功！");
		}else {
//			map.put("code", "400");
//			map.put("msg", "新增失败！");
		}
		return "redirect:/api/stu/null/null/1/5";
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @param mol
	 * @return
	 */
	@GetMapping("toUpdate")
	public String toUpdate(Integer id,Model mol) {
		mol.addAttribute("student",sBiz.findStudent(1, 1000));
		mol.addAttribute("reward",rBiz.selectByPrimaryKey(id));
		return "update";
	}
	
	/**
	 * 修改奖惩记录
	 * @param record
	 * @return
	 */
	@PostMapping("update")
	public String updateReward(Record record) {
		Integer count = rBiz.updateByPrimaryKey(record);
		if(count > 0) {
//			map.put("code", "200");
//			map.put("msg", "修改成功！");
		}else {
//			map.put("code", "400");
//			map.put("msg", "修改失败！");
		}
		return "redirect:/api/stu/null/null/1/5";
	}
	
	/**]
	 * 删除奖惩记录
	 * @param id
	 * @return
	 */
	@GetMapping("delete")
	public String deleteReward(Integer id) {
		Integer count = rBiz.deleteByPrimaryKey(id);
		if(count > 0) {
//			map.put("code", "200");
//			map.put("msg", "删除成功！");
		}else {
//			map.put("code", "400");
//			map.put("msg", "删除失败！");
		}
		return "redirect:/api/stu/null/null/1/5";
	}
	
}
