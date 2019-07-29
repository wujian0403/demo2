package com.example.demo.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * student2
 * @author 
 */
public class Student implements Serializable {
    private Integer id;

    private String code;

    private String name;

    /**
     * 1 计算机  2 电气  3 金融
     */
    private Integer major;

    private String grade;

    /**
     * 1 男   2 女
     */
    private Integer sex;

    private Date birthday;

    private String tel;

    /**
     * 1 普通学生  2 组长   3 班长
     */
    private Integer job;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

	public Student() {
		super();
	}

	public Student(Integer id, String code, String name, Integer major, String grade, Integer sex, Date birthday,
			String tel, Integer job) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.major = major;
		this.grade = grade;
		this.sex = sex;
		this.birthday = birthday;
		this.tel = tel;
		this.job = job;
	}

	public Student(String code, String name, Integer major, String grade, Integer sex, Date birthday, String tel,
			Integer job) {
		super();
		this.code = code;
		this.name = name;
		this.major = major;
		this.grade = grade;
		this.sex = sex;
		this.birthday = birthday;
		this.tel = tel;
		this.job = job;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", code=" + code + ", name=" + name + ", major=" + major + ", grade=" + grade
				+ ", sex=" + sex + ", birthday=" + birthday + ", tel=" + tel + ", job=" + job + "]";
	}
    
    
}