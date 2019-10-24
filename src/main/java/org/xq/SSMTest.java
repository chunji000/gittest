package org.xq;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xq.pojo.Cust;
//Spring测试配置
import org.xq.service.CustService;
@RunWith(SpringJUnit4ClassRunner.class)
//指定SPring的配置文件
@ContextConfiguration(value="classpath:applicationContext.xml")
public class SSMTest {
	@Autowired
	CustService custService;
	
	@Test
	public void test() {
		Cust cust = custService.queryById(1);
	}
	
	@Test
	public void testCust() {
		Cust cust = custService.queryCust(2);
		System.out.println("Cust ==" + cust);
	}
	

	@Test
	public void testInsert() {
		Cust cust = new Cust();
		cust.setName("王胖");
		cust.setPhone("1222223312");
		cust.setAddress("襄汽");
		custService.insertCust(cust);
		System.out.println("插入后Cust" + cust);
	}
	
	
	@Test
	public void testQueryIds() {
		Cust params = new Cust();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(3);
		ids.add(4);
		params.setIds(ids);
		List<Cust> cust = custService.queryByIdList(params);
		
		System.out.println("列表打印:" + cust);
	}
	
	@Test
	public void testQueryAll() {
		Cust params = new Cust();
		params.setName("叶");
		params.setAddress("山水花草");
		params.setPhone("0521-22227777");
		List<Cust> list = custService.queryAll(params);
		System.out.println(list);
	}
	
}
