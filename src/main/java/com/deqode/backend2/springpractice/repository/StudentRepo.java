package com.deqode.backend2.springpractice.repository;

import com.deqode.backend2.springpractice.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, Integer> {

}
