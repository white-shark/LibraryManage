package com.example.test.entities;


import javax.persistence.*;

//使用JPA注解配制映射
@Entity     //告诉JPA这是一个实体类（和数据表映射类）
@Table(name = "tb_fingerprint") //@Table来指定和哪个数据表对应
public class Fingerprint {

    @Id     //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column         //数据表中的列
    private String Name;
    @Column         //数据表中的列
    private String stuID;
    @Column         //数据表中的列
    private String FingerprintID;
    @Column         //数据表中的列
    public Integer getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getStuID() {
        return stuID;
    }

    public String getFingerprintID() {
        return FingerprintID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public void setFingerprintID(String fingerprintID) {
        FingerprintID = fingerprintID;
    }

    public Fingerprint(Integer id, String name, String stuID, String fingerprintID) {
        this.id = id;
        Name = name;
        this.stuID = stuID;
        FingerprintID = fingerprintID;
    }

    @Override
    public String toString() {
        return "Fingerprint{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", stuID='" + stuID + '\'' +
                ", FingerprintID='" + FingerprintID + '\'' +
                '}';
    }

}
