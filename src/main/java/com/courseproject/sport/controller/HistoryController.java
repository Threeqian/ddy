package com.courseproject.sport.controller;

import com.courseproject.sport.entity.AcceptTable;
import com.courseproject.sport.entity.InviteTable;
import com.courseproject.sport.service.AcceptTableService;
import com.courseproject.sport.service.InviteTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ddy")
public class HistoryController {
    @Autowired
    private InviteTableService inviteTableService;
    @Autowired
    private AcceptTableService acceptTableService;

    @RequestMapping(value = "/history/invitations", method = RequestMethod.POST)
    public List<InviteTable> getUserAllInvitations(@RequestBody Map<String, String> param){
        String uid = param.get("id");
        List<InviteTable> inviteTables = inviteTableService.findAllByInviterId(uid);
        return inviteTables;
    }

    @RequestMapping(value = "/history/acceptances", method = RequestMethod.POST)
    public List<InviteTable> getUserAllAcceptances(@RequestBody Map<String, String> param){
        String uid = param.get("id");
        List<AcceptTable> acceptTables = acceptTableService.findAllByAccepterId(uid);
        if (acceptTables == null){
            return null;
        }
        List<InviteTable> inviteTables = new ArrayList<>();
        for (AcceptTable accept: acceptTables){
            inviteTables.add(inviteTableService.findById(accept.getInviteId()));
        }
        return inviteTables;
    }
}
