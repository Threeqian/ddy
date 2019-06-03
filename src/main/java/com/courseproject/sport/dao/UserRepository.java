package com.courseproject.sport.dao;

import com.courseproject.sport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAll();
    User save(User user);
}
