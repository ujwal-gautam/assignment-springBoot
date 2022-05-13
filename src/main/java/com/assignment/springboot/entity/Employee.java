package com.assignment.springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_number")
    @JsonProperty(value = "phoneNumber")
    private BigInteger mobile_number;

    @Column(name = "email")
    private String email;

    @Transient
    private Integer empSalary;
}
