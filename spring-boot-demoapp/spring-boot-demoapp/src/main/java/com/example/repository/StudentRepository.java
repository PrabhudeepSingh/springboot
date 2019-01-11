package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.entity.StudentEntity;

@Component
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
