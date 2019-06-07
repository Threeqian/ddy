package com.courseproject.sport.service;

import com.courseproject.sport.dao.AcceptRepository;
import com.courseproject.sport.entity.AcceptTable;
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
        return acceptRepository.findAllByInviteId(vid);
    }

    public List<AcceptTable> findAllByAccepterId(String uid){
        return acceptRepository.findAllByAccepterId(uid);
    }

    public AcceptTable CreateAcceptInfo(Integer vid, String uid){
        AcceptTable acceptTable = new AcceptTable();
        acceptTable.setInviteId(vid);
        acceptTable.setAccepterId(uid);
        return acceptTable;
    }
}
