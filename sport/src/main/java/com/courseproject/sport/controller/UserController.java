package com.courseproject.sport.controller;

import com.courseproject.sport.entity.User;
import com.courseproject.sport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/index")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/userinfo")
    public List<User> getAll(){
        return userService.findAll();
    }

}