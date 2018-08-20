package cn.qimu.service.impl;

import cn.qimu.dao.ProcedureDao;
import cn.qimu.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcedureServiceImpl implements ProcedureService{

	@Autowired
	ProcedureDao procedureDao;
	
	@Override
	public void testAddTokenByProcedure(String userCode) {
		procedureDao.testProc1(userCode);
	}
	
}
