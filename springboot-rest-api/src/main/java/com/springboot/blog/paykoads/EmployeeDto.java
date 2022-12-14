package com.springboot.blog.paykoads;

import lombok.Data;

@Data

public class EmployeeDto {
    private long EmployeeId;
    private String FirstName;
    private  String LirstName;
    private  String Email;
    private  long Mobile;
    private  long Salary;

}
