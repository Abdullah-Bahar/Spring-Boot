package com.example.demo.service;


import com.example.demo.entity.EmployeeEntity;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeH2Implamentation implements EmployeeService
{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee empSave(Employee E) {
        if(E.getEmpID() == null || E.getEmpID().isEmpty())
        {
            E.setEmpID(UUID.randomUUID().toString());
        }

        EmployeeEntity empEnt = new EmployeeEntity();
        BeanUtils.copyProperties(E, empEnt);
        employeeRepository.save(empEnt);
        return E;
    }

    @Override
    public List<Employee> getEmployees()
    {
        List<Employee> allEmp = new ArrayList<>();

        List<EmployeeEntity> allEmpEnt = employeeRepository.findAll();

        for (EmployeeEntity et : allEmpEnt)
        {
            Employee e = new Employee();
            BeanUtils.copyProperties(et, e);
            allEmp.add(e);
        }

        return allEmp;
    }

    @Override
    public Employee getEmployeeById(String id)
    {
        EmployeeEntity en = employeeRepository.findById(id).get();
        Employee emp = new Employee();
        BeanUtils.copyProperties(en, emp);
        return emp;
    }



    @Override
    public String deleteEmployeeById(String id) {
        return null;
    }

    @Override
    public String undateEmp(String id) {
        return null;
    }
}
