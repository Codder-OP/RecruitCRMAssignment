package com.om.RecruitCRMAssignment.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.om.RecruitCRMAssignment.bean.EmployeeDetailsVO;
import com.om.RecruitCRMAssignment.bean.EmployeeVO;
import com.om.RecruitCRMAssignment.service.GetData;

@RestController
@RequestMapping("/api")
public class Endpoints {
	
	@Autowired
	private GetData getData;
	
	@GetMapping("/test")
	public String print(
		@RequestParam String id	
			) {
		return "Hi Om Prakash!!";	
	}
	
	@GetMapping("/filter")
    public List<EmployeeVO> filterEmployees(
        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date reviewDate,
        @RequestParam(required = false) List<String> departments,
        @RequestParam(required = false) List<String> projects) {
		List<EmployeeVO> employeeVO = new ArrayList<>();
		employeeVO = getData.filterEmployees(reviewDate, departments, projects);
		return employeeVO;
    }

	@GetMapping("/details")
    public EmployeeDetailsVO getEmployeeDetails(@RequestParam(required = true) int id) {
		EmployeeDetailsVO employeeDetailsVO = new EmployeeDetailsVO();
		employeeDetailsVO = getData.getEmployeeDetails(id);
		return employeeDetailsVO;
        
    }

}
