package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.StudentEntity;
import com.example.model.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<Student> result = new ArrayList<>();
        for(StudentEntity entity : students) {
            result.add(mapper.map(entity, Student.class));
        }
        return result;
    }

    public void add(Student student) {
        
        StudentEntity studentEntity = new DozerBeanMapper().map(student, StudentEntity.class);
        studentRepository.save(studentEntity);
        
    }

}
