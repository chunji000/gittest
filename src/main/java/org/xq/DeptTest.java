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
import org.xq.dao.DeptDao;
import org.xq.pojo.Cust;
import org.xq.pojo.Dept;
import org.xq.pojo.Emp;
//Spring测试配置
import org.xq.service.CustService;
import org.xq.service.EmpService;
@RunWith(SpringJUnit4ClassRunner.class)
//指定SPring的配置文件
@ContextConfiguration(value="classpath:applicationContext.xml")
public class DeptTest {
	@Autowired
	DeptDao deptDao;

	/**
	 * 一对多嵌套查询测试
	 */
	@Test
	public void testOneTomany() {
		List<Dept> deptList = deptDao.queryDeptAll();
		System.out.println("Dept1==" + deptList.size());
		for(Dept dept:deptList) {
			System.out.println("开始延迟加载:");
			System.out.println(dept.getEmps());
		}
		deptList = deptDao.queryDeptAll();
		System.out.println("Dept2==" + deptList.size());
	}
	//一对多嵌套结果测试
//	@Test
//	public void testOneTomanyForResult() {
//		List<Dept> deptList = deptDao.queryDeptForResult();
//		System.out.println("Dept==" + deptList);
//	}
	

}
