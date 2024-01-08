package com.example.demo.service;


import com.example.demo.error.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeImplamentation implements EmployeeService
{
    List<Employee> empList = new ArrayList<>();

    @Override
    public Employee empSave(Employee E)
    {
        if (E.getEmpID() == null || E.getEmpID().isEmpty())
        {
            E.setEmpID(UUID.randomUUID().toString());
        }

        empList.add(E);
        return E;
    }

    @Override
    public List<Employee> getEmployees()
    {
        return empList;
    }

    @Override
    public Employee getEmployeeById(String id)
    {
        return empList
                .stream() // List'i Strem'a donusturur ve bir koleksiyon üzerinde sıralı ve paralel operasyonları destekler.
                .filter(e -> e.getEmpID().equalsIgnoreCase(id)) // buyuk-kucuk harf duyarsiz bir sekilde karsilastirir
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("there is no " +
                                "mathcing Record with id  :" + id));
    }

    @Override
    public String deleteEmployeeById(String id)
    {
        empList.remove(getEmp(id));
        return "the Employee Record with id :" + id + " is DELETED";
    }

    @Override
    public String undateEmp(String id) {
        return null;
    }

    private Employee getEmp(String id)
    {
        return  empList
                .stream() // List'i Strem'a donusturur ve bir koleksiyon üzerinde sıralı ve paralel operasyonları destekler.
                .filter(e -> e.getEmpID().equalsIgnoreCase(id)) // buyuk-kucuk harf duyarsiz bir sekilde karsilastirir
                .findFirst()
                .orElseThrow(
                        () -> new EmployeeNotFoundException("there is no " +
                                "mathcing Record with id  :" + id));
    }
}
