package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeController2
{
    @Qualifier("employeeH2Implamentation")
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee E)
    {
        return employeeService.empSave(E);
    }

    @GetMapping
    public List<Employee> getAllEmployee()
    {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmplyeById(@PathVariable("id") String id)
    {
        return employeeService.getEmployeeById(id);
    }

}
