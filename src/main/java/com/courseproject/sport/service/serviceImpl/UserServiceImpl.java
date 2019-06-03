package com.courseproject.sport.service.serviceImpl;

import com.courseproject.sport.dao.UserRepository;
import com.courseproject.sport.entity.User;
import com.courseproject.sport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public User createNewUser(String name,String tag,String introduction,String count){
        User newUser = new User();
        newUser.setName(name);
        newUser.setTag(tag);
        newUser.setIntroduction(introduction);
        newUser.setCount(count);
        return newUser;
    }
}
