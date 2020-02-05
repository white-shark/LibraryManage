package com.example.test.repository;

import com.example.test.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee , Integer> {
    //继承JpaRepository完成数据库操作

    public Employee findByStuID(String stuID);
    public Employee save(Employee employee);

}

