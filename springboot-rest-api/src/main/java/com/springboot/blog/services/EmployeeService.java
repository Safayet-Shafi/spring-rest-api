package com.springboot.blog.services;

import com.springboot.blog.paykoads.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto  createEmployee(EmployeeDto employeeDto);


    List<EmployeeDto>getAllEmployee();
    EmployeeDto updateEmployee (EmployeeDto employeeDto,long employeeId);
    void deleteEmployeeId (long employeeId);
}
