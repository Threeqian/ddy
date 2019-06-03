package com.courseproject.sport.service;

import com.courseproject.sport.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();
    User createNewUser(String name,String tag,String introduction,String count);
}
