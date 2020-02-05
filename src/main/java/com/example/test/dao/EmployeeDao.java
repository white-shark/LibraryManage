package com.example.test.dao;

import com.example.test.entities.Employee;
import com.example.test.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Repository
@RestController

public class EmployeeDao {

    @Autowired
    EmpRepository empRepository;

    private HashMap<Integer,Employee> employees =new HashMap<>();

    public void setEmployees() {

        List<Employee> list = empRepository.findAll();
        int i;
        Employee employee = null;
        for (i=0 ; i<list.size() ; i++){
            employee = list.get(i);
            employees.put(employee.getId(),employee);
        }
    }

    //查询所有员工
    public Collection<Employee> getAll(){

        return employees.values();
    }

    public Employee get(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
    public void delete(Employee employee){
      //  employees.remove(employee);
        employees.clear();

    }

}
