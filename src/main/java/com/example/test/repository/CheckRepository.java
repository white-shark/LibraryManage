package com.example.test.repository;

import com.example.test.entities.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CheckRepository extends JpaRepository<Checkin, Integer> {

    public Checkin findAllByCheckdate(String checkdate);
}
