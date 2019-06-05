package com.courseproject.sport.service;

import com.courseproject.sport.dao.AcceptRecordRepository;
import com.courseproject.sport.entity.AcceptRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcceptRecordService {
    @Autowired
    private AcceptRecordRepository acceptRecordRepository;

    public List<AcceptRecord> findAll(){
        return acceptRecordRepository.findAll();
    }

    public List<AcceptRecord> findAllByUserId(String uid){
        return acceptRecordRepository.findAllByUserId(uid);
    }

    public AcceptRecord CreateAcceptRecord(String uid, Integer vid){
        AcceptRecord acceptRecord = new AcceptRecord();
        acceptRecord.setUserId(uid);
        acceptRecord.setAcceptId(vid);
        return acceptRecord;
    }
}
