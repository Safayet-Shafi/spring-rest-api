package com.springboot.blog.repository;

import com.springboot.blog.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositiry extends JpaRepository<Employee,Long>  {
}
