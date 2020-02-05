package com.example.test.repository;


import com.example.test.entities.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassRepository extends JpaRepository<Password, Integer> {
    //继承JpaRepository完成数据库操作

    public Password findByStuID(String stuID);
    public Password deleteByStuID(String stuID);
}
