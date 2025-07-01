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
public class EmployeeVO {
	private int id;
    private String name;
    private String email;
    private int departmentId;
    private Date dateOfJoining;
    private double salary;
    private Integer managerId;
}
