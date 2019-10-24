package org.xq.service;

import java.util.List;


import org.xq.pojo.Cust;

public interface CustService {
	
	public Cust queryCust(Integer id);
	
	public Cust queryById(Integer id);
	
	public List<Cust> queryByIdList(Cust cust);
	
	public List<Cust> queryAll(Cust cust);
	
	public void insertCust(Cust cust);

	public void updateCust(Cust cust);
	
	public void deleteById(Integer id);
}
