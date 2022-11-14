package com.deqode.backend2.springpractice.service;

import com.deqode.backend2.springpractice.model.Student;
import com.deqode.backend2.springpractice.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }
}
