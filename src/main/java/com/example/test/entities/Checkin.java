package com.example.test.entities;


import javax.persistence.*;

@Entity     //告诉JPA这是一个实体类（和数据表映射类）
@Table(name = "tb_checkin") //@Table来指定和哪个数据表对应
public class Checkin {
    @Id     //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column         //数据表中的列
    private String Name;
    @Column         //数据表中的列
    private String stuID;
    @Column         //数据表中的列
    private String checkdate;
    @Column         //数据表中的列
    private String checktime;

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

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(String checkdate) {
        this.checkdate = checkdate;
    }

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime;
    }

    public Checkin(Integer id, String name, String stuID, String checkdate, String checktime) {
        this.id = id;
        Name = name;
        this.stuID = stuID;
        this.checkdate = checkdate;
        this.checktime = checktime;
    }
    public Checkin(){

    }

    @Override
    public String toString() {
        return "Checkin{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", stuID='" + stuID + '\'' +
                ", checkdate='" + checkdate + '\'' +
                ", checktime='" + checktime + '\'' +
                '}';
    }
}
