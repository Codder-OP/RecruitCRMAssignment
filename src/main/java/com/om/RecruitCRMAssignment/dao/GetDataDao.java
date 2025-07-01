package com.om.RecruitCRMAssignment.dao;

import java.util.Date;
import java.util.List;

import com.om.RecruitCRMAssignment.bean.EmployeeDetailsVO;
import com.om.RecruitCRMAssignment.bean.EmployeeVO;

public interface GetDataDao {

	List<EmployeeVO> fetchFilterEmployees(Date reviewDate, List<String> departments, List<String> projects);

	EmployeeDetailsVO fetchEmployeeDetails(int id);

}
