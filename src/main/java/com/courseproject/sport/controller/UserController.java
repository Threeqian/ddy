package com.courseproject.sport.controller;

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

    @RequestMapping(value = "/alluser",method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.findAll();
    }

    /**
     * 通过路径给予的参数用户ID返回此ID用户对象
     * @param uid
     * @return
     */
    @RequestMapping(value = "/{uid}/userinfo",method = RequestMethod.GET)
    public User getUser(@PathVariable("uid") String uid){
        return userService.findUser(uid);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String createNewUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors())
            return errors.toString();
        userService.save(user);
        return "success";
    }
}