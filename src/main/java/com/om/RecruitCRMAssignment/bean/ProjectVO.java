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
public class ProjectVO {
    private int id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int departmentId;
}
