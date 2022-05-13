package com.assignment.springboot.service;

import com.assignment.springboot.DTO.EmployeeDTO;
import com.assignment.springboot.exceptions.DoesNotExistException;
import com.assignment.springboot.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Service to process the data received from request and perform necessary
 * operations.
 *
 * @author Ujwal
 * @since 1.0
 */


@Service
public class EmployeeServiceImp implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImp.class);
    private static final String SERVER_ERROR_MSG = "Server Error : ";

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Get pagination data of employees based on page and size
     * @param page it get page number
     * @param size total number of size
     */
    @Override
    public Page<EmployeeDTO> getEmployeeList(Integer page, Integer size) {

        try {

            Pageable sortedByIdDesc = PageRequest.of(page, size, Sort.by("empSalary").descending());
            LOGGER.info("the pageable is {}", sortedByIdDesc);
            return employeeRepository.employeeList(sortedByIdDesc);
        } catch (Exception ex) {

            LOGGER.error(SERVER_ERROR_MSG, ex);
            throw new DoesNotExistException("Data Not Found");
        }
    }

}
