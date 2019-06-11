package com.courseproject.sport.controller;

import com.courseproject.sport.entity.AcceptTable;
import com.courseproject.sport.entity.InviteTable;
import com.courseproject.sport.service.AcceptTableService;
import com.courseproject.sport.service.InviteTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ddy")
public class HistoryController {
    @Autowired
    private InviteTableService inviteTableService;
    @Autowired
    private AcceptTableService acceptTableService;

//    @RequestMapping("/history/invitations")
//    public List<InviteTable> getUserAllInvitations(@Valid String uid, Errors errors){
//        if (errors.hasErrors()){
//            return null;
//        }
//        List<InviteTable> inviteTables = inviteTableService.findAllByInviterId(uid);
//        return inviteTables;
//    }
//
//    @RequestMapping("/history/acceptances")
//    public List<InviteTable> getUserAllAcceptances(@Valid String uid, Errors errors){
//        if (errors.hasErrors()){
//            return null;
//        }
//        List<AcceptTable> acceptTables = acceptTableService.findAllByAccepterId(uid);
//        if (acceptTables == null){
//            return null;
//        }
//        List<InviteTable> inviteTables = new ArrayList<>();
//        for (AcceptTable accept: acceptTables){
//            inviteTables.add(inviteTableService.findById(accept.getInviteId()));
//        }
//        return inviteTables;
//    }
}
