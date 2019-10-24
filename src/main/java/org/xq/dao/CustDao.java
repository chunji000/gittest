package org.xq.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.xq.pojo.Cust;
@CacheNamespace
public interface CustDao {
	
	@Select("select * from cust where id = #{id}")
	@Results(value={
			@Result(column="name", property="name"),
			@Result(column="address", property="address"),
			@Result(column="phone", property="phone"),
			@Result(column="id", property="id", id=true) 
	})
	public Cust queryCust(Integer id);
	
	public Cust queryById(Integer id);
	
	public List<Cust> queryByIdList(Cust cust);
	
	public List<Cust> queryAll(Cust cust);
	
	public void insertCust(Cust cust);

	public void updateCust(Cust cust);
	
	public void deleteById(Integer id);
}
