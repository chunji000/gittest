package org.xq.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.xq.pojo.Emp;

public interface EmpService {

	Emp queryById(Integer eid);
	
	public void add(Emp emp) throws Exception;
	
	List<Emp> selectEmpById();
	
	List<Emp> selectEmpForResult();
	
	List<Emp> selectEmpForAnn();
 }
