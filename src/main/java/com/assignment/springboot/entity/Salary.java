package com.assignment.springboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "salary")
public class Salary {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "empId")
    private Integer emoId;

    @Column(name = "salaryAmount")
    private Integer salary;
}
