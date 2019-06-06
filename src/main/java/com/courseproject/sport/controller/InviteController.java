package com.courseproject.sport.controller;

import com.courseproject.sport.entity.InviteTable;
import com.courseproject.sport.entity.User;
import com.courseproject.sport.service.InviteTableService;
import com.courseproject.sport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/ddy")
public class InviteController {
    private InviteTableService inviteTableService;
    private UserService userService;

    @Autowired
    public InviteController(InviteTableService inviteTableService,UserService userService) {
        this.inviteTableService = inviteTableService;
        this.userService = userService;
    }

    /**
     * 创建表的同时将表加入到创建者的发布记录表
     * @param inviteTable，邀请表对象
     * @param errors，错误对象
     * @return
     */
    @RequestMapping(value = "/createInvite",method = RequestMethod.POST)
    public String createNewInvite(@RequestBody @Valid InviteTable inviteTable, Errors errors){
        if(errors.hasErrors())
            return "createInvite";
        inviteTableService.save(inviteTable);
        return "success";
    }

    @RequestMapping(value = "/allinvite",method = RequestMethod.GET)
    public List<InviteTable> getAll(){
        return inviteTableService.findAll();
    }


    public InviteTable findById(Integer vid){
        return inviteTableService.findById(vid);
    }

    @RequestMapping(value = "/inviteSortByAnnounceDate",method = RequestMethod.GET)
    public List<InviteTable> getAllByAnnounceDate(){
        List<InviteTable> inviteTableList = inviteTableService.findAll();
        Collections.sort(inviteTableList, Comparator.comparing(InviteTable::getAnnounceDate));
        return inviteTableList;
    }

    @RequestMapping(value = "/inviteSortByLocation",method = RequestMethod.GET)
    public List<InviteTable> getAllByLocation(){
        List<InviteTable> inviteTableList = inviteTableService.findAll();
        return inviteTableList;
    }
    /**
     * 接受邀请的同时将表加入到参与者的接受记录表
     * @param inviteTable，邀请表对象
     * @param errors，
     * @return
     */
    @RequestMapping("/acceptinvite")
    public String acceptInvite(@Valid InviteTable inviteTable, Errors errors){
        if(errors.hasErrors())
            return "acceptinvite";
        if(inviteTableService.findById(inviteTable.getId())!=null) {
            inviteTableService.updateNumber(inviteTable.getNumber() - 1, inviteTable.getId());
        }
        else
            return "无效表";
        return "success";
    }

    @RequestMapping("/score")
    public String score(Double score,Integer vid){
        InviteTable inviteTable = findById(vid);
        if(inviteTable!=null){
            User user = userService.findUser(inviteTable.getInviter_id());
            if(user != null){
                userService.updateScore((user.getScore() + score)/2,user.getId());
                return "success";
            }
            else
                return "用户不存在！";
        }
        else
            return "无效的表";
    }
}