package com.example.demo.repository;


import com.example.demo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // bu lanet olası sınıf bir spring boot veritabanı sınıfıdır
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String>
{
    /*
    JpaRepository, genel CRUD (Create,Read,Update,Delete) işlemlerini içeren bir arayüzü temsil eder.
    Bu arayüz, Spring Data JPA tarafından sağlanan bir dizi hazır metod içerir.
    Bu metodlar, genellikle temel veritabanı işlemlerini gerçekleştirmek için kullanılır.
    */
}
