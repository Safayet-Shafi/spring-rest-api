package com.springboot.blog.controller;

import com.springboot.blog.paykoads.EmployeeDto;
import com.springboot.blog.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin

public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    // create blog post
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto employeeDto){

        try{
            return  new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }

        return  new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }
    // get all post rest api
    @GetMapping
    public List<EmployeeDto> getAllEmployee(){
        return  employeeService.getAllEmployee();
    }

    // update post rest api
    @PutMapping("/{employeeId}")
    public  ResponseEntity<EmployeeDto> updateEmployee (@RequestBody EmployeeDto employeeDto,@PathVariable(name ="employeeId")long employeeId){
       EmployeeDto employeeResponse = employeeService.updateEmployee(employeeDto,employeeId);
       return new ResponseEntity<>(employeeResponse,HttpStatus.OK);
    }
    @DeleteMapping("/{employeeId}")
    public  ResponseEntity<String> deleteEmployeeById(@PathVariable(name = "employeeId")long employeeId){
        employeeService.deleteEmployeeId(employeeId);
        return new ResponseEntity<>("Employee Deleted",HttpStatus.OK);
    }

}
