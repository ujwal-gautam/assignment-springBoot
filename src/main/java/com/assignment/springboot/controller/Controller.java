package com.assignment.springboot.controller;

import com.assignment.springboot.DTO.EmployeeDTO;
import com.assignment.springboot.exceptions.InvalidDataException;
import com.assignment.springboot.service.EmployeeServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
@CrossOrigin("*")
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @GetMapping("/record")
    public Page<EmployeeDTO> getEmployeeDetails(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {

        LOGGER.info("Check validation.........");
        if (page == null || size == null) {
            throw new InvalidDataException("page or size can not be null!");
        }
        return employeeServiceImp.getEmployeeList(page, size);
    }

}
