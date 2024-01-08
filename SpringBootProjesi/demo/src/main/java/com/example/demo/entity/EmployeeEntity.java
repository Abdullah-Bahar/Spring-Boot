package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/*
 @Entity :  sınıfın bir JPA entity (varlık) sınıfı olduğunu belirtir.
    Bu, sınıfın bir veritabanı tablosuyla eşleşeceği ve
    veritabanında saklanabilecek nesneleri temsil ettiği anlamına gelir.

 @Table :  'Entity' sınıfının hangi veritabanı tablosu ile ilişkilendirileceğini belirtir.
    'name' parametresi, veritabanındaki tablonun adını belirtir.
    Bu durumda, "tbl_Employee" adlı bir tablo ile eşleşecektir.

 @Id : O filed'ın primary key oldugunu belirtir.
*/
@Entity
@Table(name = "tbl_Employee")
public class EmployeeEntity
{
    @Id
    private String empID;
    private String empFirstName;
    private String empLastName;
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
