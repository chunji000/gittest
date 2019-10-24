package org.xq.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Emp implements Serializable {
	private Integer eid;     
	private String ename;   
	private String sex;     
	private Integer age;     
	private Date statdata;
	private Integer salary;  
	
	private Dept dept;
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getStatdata() {
		return statdata;
	}
	public void setStatdata(Date statdata) {
		this.statdata = statdata;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", sex=" + sex + ", age=" + age + ", statdata=" + statdata
				+ ", salary=" + salary + ", dept=" + dept + "]";
	}



	
	
}
