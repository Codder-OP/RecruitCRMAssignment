package com.om.RecruitCRMAssignment.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProjectVO {
    private int employee_id;
    private int project_id;
    private Date assigned_date;
    private String role;
}
