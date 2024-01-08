package com.example.demo.service;


import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService
{
    public Employee empSave(Employee E);

    public List<Employee> getEmployees();

    public Employee getEmployeeById(String id);

    public String deleteEmployeeById(String id);

    public String undateEmp(String id);
}
