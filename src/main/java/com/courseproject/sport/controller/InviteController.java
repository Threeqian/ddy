package com.courseproject.sport.controller;

import com.courseproject.sport.dao.InviteRepository;
import com.courseproject.sport.entity.inviteTable;
import com.courseproject.sport.service.InviteTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ddy")
public class InviteController {
    private InviteTableService inviteTableService;
    private InviteRepository inviteRepository;

    @Autowired
    public InviteController(InviteTableService inviteTableService, InviteRepository inviteRepository) {
        this.inviteTableService = inviteTableService;
        this.inviteRepository = inviteRepository;
    }

    @RequestMapping("/allinviteinfo")
    public List<inviteTable> getAll(){
        return inviteTableService.findAll();
    }




    @RequestMapping(value = "/createInvite",method = RequestMethod.POST)
    public String createNewInvite(@Valid inviteTable i, Errors errors){
        if(errors.hasErrors())
            return "createInvite";
        inviteRepository.save(i);
        return "success";
    }

}
