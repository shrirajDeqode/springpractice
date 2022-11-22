package com.deqode.backend2.springpractice.repository;

import com.deqode.backend2.springpractice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, String> {
    User findByUserName(String userName);
}
