package org.xq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.xq.pojo.Dept;

public interface DeptDao {
	Dept queryDeptById(int did);
	List<Dept> queryDeptAll();
	List<Dept> queryDeptForResult();
	@Insert("insert into dept values (null, #{deptName})")
	void insertDept(Dept dept);
}
