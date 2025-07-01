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
public class PerformanceReviewVO {
    private int id;
    private int employeeId;
    private Date reviewDate;
    private int score;
    private String reviewComments;

}
