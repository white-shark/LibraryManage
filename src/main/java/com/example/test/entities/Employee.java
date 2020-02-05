package com.example.test.entities;

import javax.persistence.*;

//使用JPA注解配制映射
@Entity     //告诉JPA这是一个实体类（和数据表映射类）
@Table(name = "tb_information") //@Table来指定和哪个数据表对应
public class Employee{
    @Id     //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column         //数据表中的列
    private String Name;
    @Column
    private String Phone;
    //1 male, 0 female
    @Column
    private Integer gender;
    @Column
    private String stuID;
    @Column
    private String classID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public Employee(String name, String phone, Integer gender, String stuID, String classID) {
        Name = name;
        Phone = phone;
        this.gender = gender;
        this.stuID = stuID;
        this.classID = classID;
    }
    public Employee(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", gender=" + gender +
                ", stuID='" + stuID + '\'' +
                ", classID='" + classID + '\'' +
                '}';
    }
}