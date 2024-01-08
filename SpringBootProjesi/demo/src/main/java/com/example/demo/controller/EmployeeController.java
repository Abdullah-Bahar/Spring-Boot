package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController
{
    @Qualifier("employeeImplamentation") // Eger interface'den bir fazla sınıf iplemente ediliyorsa hangisini almasi gerektigini belirtiriz
    // implamantasyonun yapıldıgı sınıfıb bas hatdi ufak harfle yazılmalı
    @Autowired  // Constructor'un yaptıgını bu anatasyon ile otomatik olarak yaptiririz
                // interface'in nesnesi olamiyacagi icin ondan implemente edilen bir sinif aranir
    EmployeeService service;


    // Yuakrida otomatik olarak enjeksiyon gerçekleştiği için  burada burada constructor kullanmiyoruz
    // Eger manuel enjeksiyondan bahsedecek olursak consturtor kullanabiliiriz
    /*
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    */

    @PostMapping
    public Employee save(@RequestBody Employee E)
    {
        return service.empSave(E);
    }

    @GetMapping
    public List<Employee> gwtAllEmployees()
    {
        return service.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") String idEmp)
    {
        return service.getEmployeeById(idEmp);
    }

    @GetMapping("/myParam")
    public Employee getEmployeeByParam(@RequestParam("id") String id)
    {
        return service.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") String deleteId)
    {
        return service.deleteEmployeeById(deleteId);
    }

}
