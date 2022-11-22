package com.deqode.backend2.springpractice.controller;

import com.deqode.backend2.springpractice.model.Student;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "student")
public class StudentController {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    com.deqode.backend2.springpractice.service.StudentService StudentService;

    @GetMapping("/findAllStudent")
    public List<Student> getAllStudent() {
        logger.info("Entry:StudentController.getAllStudent");
        List<Student> studentList = StudentService.getAllStudent();
        logger.info("Exit:StudentController.getAllStudent");
        return studentList;
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        logger.info("Entry:StudentController.addStudent");
        Student addedStudent1 = StudentService.addStudent(student);
        logger.info("Exit:StudentController.addStudent");
        return addedStudent1;
    }


    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        logger.info("Entry:StudentController.deleteStudent");
        StudentService.deleteStudent(id);
        logger.info("Exit:StudentController.deleteStudent");
        return "Deleted Successfully";
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        logger.info("Entry:StudentController.updateStudent");
        Student updatedStudent = StudentService.updateStudent(student);
        logger.info("Exit:StudentController.updateStudent");
        return updatedStudent;
    }

}
