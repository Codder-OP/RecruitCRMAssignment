package com.om.RecruitCRMAssignment.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.RecruitCRMAssignment.bean.EmployeeDetailsVO;
import com.om.RecruitCRMAssignment.bean.EmployeeVO;
import com.om.RecruitCRMAssignment.dao.GetDataDao;

@Service
public class GetData {
	@Autowired
	private GetDataDao getDataDao;
	
	public List<EmployeeVO> filterEmployees(Date reviewDate, List<String> departments, List<String> projects) {
		List<EmployeeVO> employeeVO = new ArrayList<>();
		if(Objects.nonNull(reviewDate) && departments != null && !departments.isEmpty() && projects != null && !projects.isEmpty()) {
			employeeVO = getDataDao.fetchFilterEmployees(reviewDate, departments, projects);
		}	
		return employeeVO;
	}

	public EmployeeDetailsVO getEmployeeDetails(int id) {
		return getDataDao.fetchEmployeeDetails(id);
	}
	

}
