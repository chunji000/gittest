package org.xq.controller;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xq.Commons;
import org.xq.pojo.Cust;
import org.xq.service.CustService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CustController {
	@Autowired
	CustService custService;
	
	/**
	 * @PathVariable("id") 用于路径上的变量绑定,如:cust/{id}
	 * @param id
	 * @return
	 */
	@GetMapping("cust/{id}")
	@ResponseBody
	public Cust getCustById(@PathVariable("id") int id) {
		return custService.queryById(id);
	}
	
	@GetMapping("cust/query")
	@ResponseBody
	public PageInfo  getCustById(@RequestParam(required=true, defaultValue="1") Integer pageNum, Cust cust) {
		//启动分页使用
		PageHelper.startPage(pageNum, Commons.pageSize);
		List<Cust> custList = custService.queryAll(cust);
		//创建PageInfo分页对象, 把数据塞入PageInfo中
		PageInfo<Cust> pageInfo = new PageInfo<>(custList);
		return pageInfo;
	}
	
	@PostMapping("cust")
	@ResponseBody
	public Map<String, Object> add(Cust cust) {
		Map<String, Object> resultJson = new HashMap();
		try {
		custService.insertCust(cust);
			resultJson.put("status", "success");
			resultJson.put("msg", "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			resultJson.put("status", "fail");
			resultJson.put("msg", "添加失败");
		}
		return resultJson;
	}
	
	
	@PutMapping("cust")
	@ResponseBody
	public Map<String, Object> update(Cust cust) {
		Map<String, Object> resultJson = new HashMap();
		try {
		custService.updateCust(cust);
			resultJson.put("status", "success");
			resultJson.put("msg", "修改成功");
		} catch (Exception e) {
			resultJson.put("status", "fail");
			resultJson.put("msg", "修改失败");
		}
		return resultJson;
	}
	@DeleteMapping("cust/{id}")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id") int id) {
		Map<String, Object> resultJson = new HashMap();
		try {
			custService.deleteById(id);
			resultJson.put("status", "success");
			resultJson.put("msg", "删除成功");
		} catch (Exception e) {
			resultJson.put("status", "fail");
			resultJson.put("msg", "删除失败");
		}
		return resultJson;
	}

	@GetMapping("hello")
	public String hello(){
		return "hello";
	}
}
