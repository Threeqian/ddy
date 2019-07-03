package com.courseproject.sport.controller;

import com.courseproject.sport.entity.InviteTable;
import com.courseproject.sport.entity.User;
import com.courseproject.sport.service.UserService;
import com.courseproject.sport.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ddy")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryController history;
    @Autowired
    private InviteController inviteController;

    @RequestMapping(value = "/alluser", method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.findAll();
    }

    /**
     * 通过路径给予的参数用户ID返回此ID用户对象
     * @return
     */
    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public User getUser(@RequestBody Map<String, String> param) {
        return userService.findUser(param.get("id"));
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String createNewUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors())
            return errors.toString();
        userService.save(user);
        return "success";
    }

    @RequestMapping(value = "/getopenid", method = RequestMethod.POST)
    public String getOpenId(@RequestBody Map<String, String> param) {
        String code = param.get("code");
        return UserUtil.getOpenid(code);
    }

    @RequestMapping(value = "/gettingstart", method = RequestMethod.POST)
    public Map<String, Object> getStart(@RequestBody Map<String, String> param){
        Map<String, Object> map = new HashMap<>();
        String uid = param.get("id");
        User user = getUser(param);
        if (user == null){
            user = userService.CreateUser(uid, param.get("name"), param.get("img"),
                    "sport", "don't stop", 5.0);
            //userService.save(user);
        }
        map.put("user", user);
        List<InviteTable> inviteTables = history.getUserAllInvitations(param);
        map.put("invitations", inviteTables);
        List<InviteTable> acceptTables = history.getUserAllAcceptances(param);
        map.put("acceptances", acceptTables);
        List<InviteTable> allInvite = inviteController.getAll();
        if (allInvite.size() > 20)
            allInvite = allInvite.subList(0,20);
        map.put("allInvite", allInvite);
        return map;
    }
}