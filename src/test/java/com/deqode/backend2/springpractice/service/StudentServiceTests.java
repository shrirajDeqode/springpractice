package com.deqode.backend2.springpractice.service;

import com.deqode.backend2.springpractice.model.Student;
import com.deqode.backend2.springpractice.repository.StudentRepo;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTests {

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentService studentService;

    private static Student student;

    @BeforeAll
    static void setUp() {
        student = new Student(1, "Modi", "Pune");
    }

    @Test
    void getAllPerson() {
        when(studentRepo.findAll()).thenReturn(List.of(student));
        List<Student> studentList = studentService.getAllStudent();
        Assert.notEmpty(studentList, "Student list should not be empty");

    }

    @Test
    void saveStudent() {
        when(studentRepo.save(any())).thenReturn(student);
        Assert.notNull(studentService.addStudent(student), "Student list should not be empty");

    }

    @Test
    void deleteStudent() {
        doNothing().when(studentRepo).deleteById(anyInt());
        studentService.deleteStudent(3);
        verify(studentRepo, times(1)).deleteById(anyInt());
    }
}