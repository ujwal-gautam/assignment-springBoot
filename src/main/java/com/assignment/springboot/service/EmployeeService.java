package com.assignment.springboot.service;

import com.assignment.springboot.DTO.EmployeeDTO;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    public Page<EmployeeDTO> getEmployeeList(Integer page, Integer size);
}
