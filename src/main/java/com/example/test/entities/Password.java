package com.example.test.entities;


import javax.persistence.*;

//使用JPA注解配制映射
@Entity     //告诉JPA这是一个实体类（和数据表映射类）
@Table(name = "tb_password") //@Table来指定和哪个数据表对应
public class Password {

    @Id     //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column         //数据表中的列
    private String stuID;
    @Column
    private String password = null;
    @Column
    private Integer identity;

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getIdentity() {
        return identity;
    }

    public Integer getId() {
        return id;
    }

    public String getStuID() {
        return stuID;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Password(Integer id, String stuID, String password,Integer identity) {
        super();
        this.id = id;
        this.stuID = stuID;
        this.password = password;
        this.identity = identity;
    }

    public Password() {
    }

    @Override
    public String toString() {
        return "Password{" +
                ", stuID='" + stuID + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
