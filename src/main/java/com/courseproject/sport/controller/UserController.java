package com.courseproject.sport.controller;

import com.courseproject.sport.dao.UserRepository;
import com.courseproject.sport.entity.User;
import com.courseproject.sport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ddy")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/alluser")
    public List<User> getAll(){
        return userService.findAll();
    }

    /**
     * 通过路径给予的参数用户ID返回此ID用户对象
     * @param uid
     * @return
     */
    @RequestMapping("/{uid}/userinfo")
    public User getUser(@PathVariable("uid") String uid){
        return userService.findUser(uid);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String createNewUser(@Valid User user, Errors errors){
        if(errors.hasErrors())
            return "register";
        userRepository.save(user);
        return "success";
    }


}