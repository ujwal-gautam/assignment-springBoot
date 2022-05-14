package com.assignment.springboot.repository;

import com.assignment.springboot.DTO.EmployeeDTO;
import com.assignment.springboot.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select e.id as id, e.name as name, e.address as address, e.mobile_number as phoneNumber" +
            " ,e.email as email, s.salaryAmount as empSalary from employee e inner join salary s on s.empId=e.id", countQuery = "select e.id as id, e.name as name, e.address as address, e.mobile_number as phoneNumber" +
            " ,e.email as email, s.salaryAmount as empSalary from employee e inner join salary s on s.empId=e.id", nativeQuery = true)
    Page<EmployeeDTO> employeeList(Pageable sortedByIdDesc);


}
