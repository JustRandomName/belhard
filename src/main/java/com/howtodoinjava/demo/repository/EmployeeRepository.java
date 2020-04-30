package com.howtodoinjava.demo.repository;

import com.howtodoinjava.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    List<Employee> findAll();
//
//    @Query("SELECT em from Employee em where em.email = ?1 and em.firstName = ?2")
//    Employee findALLByEmailAndFirstName(String email, String s);
//
//
//    @Query(nativeQuery = true, value = "SELECT * from employees where first_name = ?1")
//    Employee findALLByEmailAndFirstName(String email, String s);
//

    Employee findOneByFirstNameAndEmail(String firstName, String email);

}
