package org.xq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xq.pojo.Cust;
import org.xq.pojo.Dept;
import org.xq.pojo.Emp;
//Spring测试配置
import org.xq.service.CustService;
import org.xq.service.EmpService;
@RunWith(SpringJUnit4ClassRunner.class)
//指定SPring的配置文件
@ContextConfiguration(value="classpath:applicationContext.xml")
public class EmpTest {
	@Autowired
	EmpService empService;
	//测试多对一注解
//	@Test
//	public void testOneForAnn() {
//		List<Emp> empList = empService.selectEmpForAnn();
//		System.out.println("Emp" + empList);
//	}
//	
//	@Test
//	public void testManyToOne() {
//		List<Emp> empList = empService.selectEmpById();
//		System.out.println("Emp" + empList);
//	}
//	
//	//测试嵌套结果查询
//	@Test
//	public void testManyToOne2() {
//		List<Emp> empList = empService.selectEmpForResult();
//		System.out.println("Emp222" + empList);
//	}
//	
//	@Test
//	public void test() {
//		Emp emp = empService.queryById(3);
//		System.out.println("Emp" + emp);
//	}

	@Test
	public void testAdd() throws Exception {
		Emp emp = new Emp();
		emp.setEname("三三666");
		emp.setAge(20);
		emp.setSex("女");
		emp.setSalary(3000);
		emp.setStatdata(new Date());
		Dept dept = new Dept();
		dept.setDid(100);
		dept.setDeptName("后勤部门111");
		emp.setDept(dept);
		empService.add(emp);
	
	}

}
