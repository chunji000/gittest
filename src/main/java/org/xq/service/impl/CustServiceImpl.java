package org.xq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xq.dao.CustDao;
import org.xq.pojo.Cust;
import org.xq.service.CustService;

@Service
public class CustServiceImpl implements CustService {
	
	@Autowired
	CustDao custDao;
	
	@Override
	public Cust queryById(Integer id) {
		// TODO Auto-generated method stub
		return custDao.queryById(id);
	}

	@Override
	public List<Cust> queryAll(Cust cust) {
		// TODO Auto-generated method stub
		return custDao.queryAll(cust);
	}

	@Override
	public void insertCust(Cust cust) {
		custDao.insertCust(cust);
	}

	@Override
	public void updateCust(Cust cust) {
		custDao.updateCust(cust);
	}

	@Override
	public void deleteById(Integer id) {
		custDao.deleteById(id);
	}

	@Override
	public List<Cust> queryByIdList(Cust cust) {
		// TODO Auto-generated method stub
		return custDao.queryByIdList(cust);
	}

	@Override
	public Cust queryCust(Integer id) {
		// TODO Auto-generated method stub
		return custDao.queryCust(id);
	}

}
