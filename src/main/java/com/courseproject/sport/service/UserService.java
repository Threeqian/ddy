package com.courseproject.sport.service;

import com.courseproject.sport.dao.UserRepository;
import com.courseproject.sport.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUser(String uid){
        Optional<User> opu = userRepository.findById(uid);
        return opu.orElse(null);
    }

    public User CreateUser(String uid, String name, String imgUrl, String tag, String introduction, Double score){
        User user = new User();
        user.setId(uid);
        user.setName(name);
        user.setUserImg(imgUrl);
        user.setTag(tag);
        user.setIntroduction(introduction);
        user.setScore(score);
        return user;
    }

    public User save(User user){
        return userRepository.save(user);
    }

}
