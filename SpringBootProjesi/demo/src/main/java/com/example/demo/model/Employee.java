package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"empDepartment"})
public class Employee
{
    /*
    - JSON Serileştirmesi : nesneyi JSON'a çevirme
    - JSON deserializasyon : JSON'ı nesneye çevirmek

    - @JsonIgnoreProperties({"empDepartment"}) :  belirtilen sınıfın JSON temsilinde
        dikkate alınmamasını istediğimiz alanları belirler. JSON temsilinden hariç tutulur

    - @JsonIgnore : belirli bir alanın JSON temsilinden tamamen çıkarılmasını sağlar.
        Yani hem seri. ve deseri. işlemlerinde bu alan işleme alınmaz
    */
    private String empID;
    private String empFirstName;
    private String empLastName;
    @JsonIgnore
    private String empDepartment;
    private String empEmail;

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }
}
