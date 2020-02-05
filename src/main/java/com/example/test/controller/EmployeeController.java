package com.example.test.controller;

import com.example.test.dao.EmployeeDao;
import com.example.test.entities.Employee;
import com.example.test.entities.Password;
import com.example.test.repository.EmpRepository;
import com.example.test.repository.PassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;


@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmpRepository empRepository;

    @Autowired
    PassRepository passRepository;

    @GetMapping("/user/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        Employee employee;
        employee = empRepository.getOne(id);
        System.out.println(employee);
        return employee;
    }
    @GetMapping("/emps")
    public String list(Model model , HttpSession session){
        employeeDao.setEmployees();
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);
        String username = (String) session.getAttribute("loginUser");
        Integer identity = (Integer) session.getAttribute("identity");
        int i = Integer.valueOf(identity);
        if(i == 1){
            return "list";
        }
        else{
            return "liststu";
        }

    }
    //跳转添加页面
    @GetMapping("/emp")
    public String toAddemp(HttpSession session){
        Integer identity = (Integer) session.getAttribute("identity");
        int i = Integer.valueOf(identity);
        if (i==1) {
            return "add";
        }
        else {
            return "dashboard";
        }
    }

    //成员添加
    //springMVC自动将请求参数和入参对象对应绑定，请求参数名和对象名一致
    @PostMapping("/emp")
    public String addEmp(Employee employee,HttpSession session){

        Integer identity = (Integer) session.getAttribute("identity");
        int i = Integer.valueOf(identity);
        if(i==1) {

            empRepository.save(employee);
            Password password = new Password();
            password.setStuID(employee.getStuID());
            password.setPassword("000000");
            password.setIdentity(0);
            passRepository.save(password);

            //返回列表界面
            //redirect:重定向到地址
            //forward：转发地址
            return "redirect:/emps";
        }
        else {
            return "dashboard";
        }
    }

    //跳转修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model,HttpSession session){

        Integer identity = (Integer) session.getAttribute("identity");
        int i = Integer.valueOf(identity);
        if (i==1) {
            Employee employee = employeeDao.get(id);
            model.addAttribute("emp", employee);
            Password password = null;
            password.setStuID(employee.getStuID());
            return "edit";
        }
        else {
            return "dashboard";
        }
    }

    //修改信息
    @PutMapping("/emp")
    public String editEmployee(Employee employee){
        empRepository.save(employee);
        return "redirect:/emps";
    }
    //删除信息
    @GetMapping("/empdel/{id}")
    public String toDeletePage(@PathVariable("id") Integer id,Model model,HttpSession session) {
        Integer identity = (Integer) session.getAttribute("identity");
        int i = Integer.valueOf(identity);
        if (i==1) {
            Employee employee = employeeDao.get(id);
            model.addAttribute("emp", employee);
            return "delete";
        }
        else {
            return "dashboard";
        }
    }

    @PutMapping("/empdel")
    public String deleEmployee(Employee employee){
        empRepository.delete(employee);
        employeeDao.delete(employee);
        Password password = new Password();
        password = passRepository.findByStuID(employee.getStuID());
        passRepository.delete(password);
        //passRepository.deleteByStuID(employee.getStuID());
        return "redirect:/emps";
    }

}

