package com.springboot.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "restemployees",uniqueConstraints = {@UniqueConstraint(columnNames={"email"})}
)

public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private long EmployeeId;

    @Column(name="FirstName",nullable = false)
    private String FirstName;

    @Column(name="LirstName",nullable = false)
    private  String LirstName;

    @Column(name="Email",nullable = false)
    private  String Email;

    @Column(name="Mobile",nullable = false)
    private  long Mobile;

    @Column(name="Salary",nullable = false)
    private  long Salary;


}
