package com.om.RecruitCRMAssignment.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailsVO {
    private EmployeeVO employee;
    private DepartmentVO department;
    private List<ProjectVO> projects;
    private List<PerformanceReviewVO> recentReviews;

}
