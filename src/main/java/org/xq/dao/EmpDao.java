package org.xq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.xq.pojo.Emp;

public interface EmpDao {

	@Select("select * from emp where did = #{value}")
	Emp queryById(Integer did);

	@Insert(" insert into emp(ename, sex, age, statdata, salary, did) " + "values ( #{ename}, #{sex}, #{age}, "
			+ "#{statdata,jdbcType=DATE}, #{salary}, #{dept.did})")
	public void add(Emp emp);

	List<Emp> selectEmpById();

	List<Emp> selectEmpForResult();

	@Select("select * from emp ")
	// @Results 相当于 <resultMap>
	// @Result 相当于 <result>
	@Results({
		//多对一嵌套查询
			@Result(property = "dept", column = "did", javaType = org.xq.pojo.Dept.class, 
					one = @One(select = "org.xq.dao.DeptDao.queryDeptById")) })
	List<Emp> selectEmpForAnn();
}
