package com.springboot.blog.services.impl;

import com.springboot.blog.entity.Employee;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.paykoads.EmployeeDto;
import com.springboot.blog.repository.EmployeeRepositiry;
import com.springboot.blog.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepositiry employeeRepositiry;

    public EmployeeServiceImpl(EmployeeRepositiry employeeRepositiry) {
        this.employeeRepositiry = employeeRepositiry;
    }



    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // convert DTO to entity

        Employee employee =mapToEntity(employeeDto);

//        Employee employee =new Employee();
//        employee.setFirstName(employeeDto.getFirstName());
//        employee.setLirstName(employeeDto.getLirstName());
//        employee.setEmail(employeeDto.getEmail());
//        employee.setMobile(employeeDto.getMobile());
//        employee.setSalary(employeeDto.getSalary());
        Employee newEmployee = employeeRepositiry.save(employee);
        // convert Entity to dto
        EmployeeDto employeeResponse = mapToDto(newEmployee);

//        EmployeeDto employeeResponse = new EmployeeDto();
//        employeeResponse.setEmployeeId(newEmployee.getEmployeeId());
//        employeeResponse.setFirstName(newEmployee.getFirstName());
//        employeeResponse.setLirstName(newEmployee.getLirstName());
//        employeeResponse.setEmail(newEmployee.getEmail());
//        employeeResponse.setMobile(newEmployee.getMobile());
//        employeeResponse.setSalary(newEmployee.getSalary());

        return  employeeResponse;

    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepositiry.findAll();
        return employees.stream().map(employee -> mapToDto(employee)).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, long employeeId) {
        Employee employee = employeeRepositiry.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee","employeeId",employeeId));

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLirstName(employeeDto.getLirstName());
        employee.setEmail(employeeDto.getEmail());
        employee.setMobile(employeeDto.getMobile());
        employee.setSalary(employeeDto.getSalary());

        Employee updatedEmployee = employeeRepositiry.save(employee);
        return mapToDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeId(long employeeId) {
        Employee employee = employeeRepositiry.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee","employeeId",employeeId));
        employeeRepositiry.delete(employee);

    }


    // convert entity to dto
    private EmployeeDto mapToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLirstName(employee.getLirstName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setMobile(employee.getMobile());
        employeeDto.setSalary(employee.getSalary());

        return employeeDto;
    }

    // convert dto to entity

    private Employee mapToEntity(EmployeeDto employeeDto){
         Employee employee = new Employee();
         employee.setFirstName(employeeDto.getFirstName());
         employee.setLirstName(employeeDto.getLirstName());
         employee.setEmail(employeeDto.getEmail());
         employee.setMobile(employeeDto.getMobile());
         employee.setSalary(employeeDto.getSalary());

         return  employee;
    }
}
