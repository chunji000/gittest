package org.xq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.xq.dao.DeptDao;
import org.xq.dao.EmpDao;
import org.xq.pojo.Dept;
import org.xq.pojo.Emp;
import org.xq.service.EmpService;

//给添加方法加事务
/**
 * isolation 隔离级别
 * propagation 传播行为
 * rollbackFor 哪些异常回滚
 */
@Transactional(isolation = Isolation.READ_COMMITTED, 
		propagation = Propagation.REQUIRES_NEW, 
		rollbackFor = Exception.class)
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDao empDao;

	@Autowired
	DeptDao deptDao;

	@Override
	public Emp queryById(Integer eid) {

		return empDao.queryById(eid);
	}
	

	@Override
	public void add(Emp emp) throws Exception {
		// 查询是否有该部门,如果没有则添加一个部门
		Dept dept = deptDao.queryDeptById(emp.getDept().getDid());
		if (dept == null) {
			// 插入部门
			deptDao.insertDept(emp.getDept());
			// throw new Exception("部门插入失败!!!");
		}
		empDao.add(emp);
	}

	@Override
	public List<Emp> selectEmpById() {
		return empDao.selectEmpById();
	}

	@Override
	public List<Emp> selectEmpForResult() {
		// TODO Auto-generated method stub
		return empDao.selectEmpForResult();
	}

	@Override
	public List<Emp> selectEmpForAnn() {
		return empDao.selectEmpForAnn();
	}

}
