package com.courseproject.sport.service;

import com.courseproject.sport.dao.AcceptRepository;
import com.courseproject.sport.entity.AcceptTable;
import com.courseproject.sport.entity.InviteTable;
import com.courseproject.sport.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcceptTableService {
    @Autowired
    private AcceptRepository acceptRepository;

    public List<AcceptTable> findAll(){
        return acceptRepository.findAll();
    }

    public List<AcceptTable> findAllByInviteId(Integer vid){
        return acceptRepository.findAllByInviteTable_Id(vid);
    }

    public List<AcceptTable> findAllByAccepterId(String uid){
        return acceptRepository.findAllByAccepter_Id(uid);
    }

    public AcceptTable CreateAcceptInfo(InviteTable inviteTable, User user){
        AcceptTable acceptTable = new AcceptTable();
        //维护外键
        acceptTable.setInviteTable(inviteTable);
        acceptTable.setAccepter(user);
        //级联
        inviteTable.getAcceptTables().add(acceptTable);
        user.getAcceptTables().add(acceptTable);
        return acceptTable;
    }
}
