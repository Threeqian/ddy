package com.courseproject.sport.controller;

import com.courseproject.sport.entity.User;
import com.courseproject.sport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ddy")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/userinfo")
    public List<User> getAll(){
        return userService.findAll();
    }

    /**
     * 通过路径给予的参数用户ID返回此ID用户对象
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("/{uid}/userinfo")
    public User getUser(@PathVariable("uid") String uid){
        return userService.findUser(uid);
    }

}