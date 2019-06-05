package com.courseproject.sport.service;

import com.courseproject.sport.dao.AcceptTableRepository;
import com.courseproject.sport.entity.AcceptTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcceptTableService {
    @Autowired
    private AcceptTableRepository acceptTableRepository;

    public List<AcceptTable> findAll(){
        return acceptTableRepository.findAll();
    }

    public List<AcceptTable> findAllByInviteId(Integer vid){
        return acceptTableRepository.findAllByInviteId(vid);
    }

    public AcceptTable CreateAcceptInfo(Integer vid, String uid){
        AcceptTable acceptTable = new AcceptTable();
        acceptTable.setInviteId(vid);
        acceptTable.setAccepterId(uid);
        return acceptTable;
    }
}
