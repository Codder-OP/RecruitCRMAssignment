package com.om.RecruitCRMAssignment.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.om.RecruitCRMAssignment.bean.DepartmentVO;
import com.om.RecruitCRMAssignment.bean.EmployeeDetailsVO;
import com.om.RecruitCRMAssignment.bean.EmployeeVO;
import com.om.RecruitCRMAssignment.bean.PerformanceReviewVO;
import com.om.RecruitCRMAssignment.bean.ProjectVO;
import com.om.RecruitCRMAssignment.dao.GetDataDao;

@Repository
public class GetDataDaoImpl implements GetDataDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<EmployeeVO> fetchFilterEmployees(Date reviewDate, List<String> departments, List<String> projects) {
		String sql = "SELECT DISTINCT e.* FROM employee e " +
                "JOIN department d ON e.department_id = d.id " +
                "LEFT JOIN employee_project ep ON e.id = ep.employee_id " +
                "LEFT JOIN project p ON ep.project_id = p.id " +
                "LEFT JOIN performance_review pr ON e.id = pr.employee_id " +
                "WHERE pr.review_date = :reviewDate " +
                "AND d.name IN (:departments)" +
                "AND p.name IN (:projects)";

   
		Map<String, Object> params = new HashMap<>();
	    params.put("reviewDate", reviewDate);
	    params.put("departments", departments);
	    params.put("projects", projects);
   System.out.println("PARAMS---->"+ params);
   List<EmployeeVO> employeeVO = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(EmployeeVO.class));
   return employeeVO;
	}

	@Override
	public EmployeeDetailsVO fetchEmployeeDetails(int id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		String empSql = "SELECT * FROM employee WHERE id = :id ";
		List<EmployeeVO> emp = namedParameterJdbcTemplate.query(empSql, params, new BeanPropertyRowMapper<>(EmployeeVO.class));
        
        String deptSql = "SELECT * FROM department WHERE id = :depId ";
        Map<String, Object> param1 = new HashMap<>();
		param1.put("depId", emp.get(0).getDepartmentId());
		List<DepartmentVO> dept = namedParameterJdbcTemplate.query(deptSql, param1, new BeanPropertyRowMapper<>(DepartmentVO.class));

        String projSql = "SELECT p.* FROM project p JOIN employee_project ep ON p.id = ep.project_id WHERE ep.employee_id = :id ";
        List<ProjectVO> projs = namedParameterJdbcTemplate.query(projSql, params, new BeanPropertyRowMapper<>(ProjectVO.class));

        String revSql = "SELECT * FROM performance_review WHERE employee_id = :id ORDER BY review_date DESC LIMIT 3";
        List<PerformanceReviewVO> reviews = namedParameterJdbcTemplate.query(revSql, params, new BeanPropertyRowMapper<>(PerformanceReviewVO.class));

        EmployeeDetailsVO employeeDetailsVO = new EmployeeDetailsVO();
        employeeDetailsVO.setEmployee(emp.get(0));
        employeeDetailsVO.setDepartment(dept.get(0));
        employeeDetailsVO.setProjects(projs);
        employeeDetailsVO.setRecentReviews(reviews);
        return employeeDetailsVO;
	}

}
