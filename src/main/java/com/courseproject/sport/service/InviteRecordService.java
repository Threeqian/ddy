package com.courseproject.sport.service;

import com.courseproject.sport.dao.InviteRecordRepository;
import com.courseproject.sport.entity.InviteRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InviteRecordService {
    @Autowired
    private InviteRecordRepository inviteRecordRepository;

    public List<InviteRecord> findAll(){
        return inviteRecordRepository.findAll();
    }

    public List<InviteRecord> findAllByUserId(String uid){
        return inviteRecordRepository.findAllByUserId(uid);
    }

    public InviteRecord CreateInviteRecord(String uid, Integer vid){
        InviteRecord inviteRecord = new InviteRecord();
        inviteRecord.setUserId(uid);
        inviteRecord.setInviteId(vid);
        return inviteRecord;
    }
}
