package com.courseproject.sport.service;

import com.courseproject.sport.dao.InviteRepository;
import com.courseproject.sport.entity.InviteTable;
import com.courseproject.sport.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@Service
public class InviteTableService {

    @Autowired
    private InviteRepository inviteRepository;

    //返回有效日期的结果集
    List<InviteTable> valid(List<InviteTable> list){
        List<InviteTable> validable = list;
        Date date = new Date(new java.util.Date().getTime());
        for(InviteTable i:validable){
            long day = (date.getTime() - i.getAnnounceDate().getTime()) / (1000 * 3600 * 24);
            if(i.getValidDay() > day){
                validable.remove(i);
            }
        }
        return validable;
    }

    InviteTable valid(InviteTable inviteTable){
        Date date = new Date(new java.util.Date().getTime());
        long day = (date.getTime() - inviteTable.getAnnounceDate().getTime()) / (1000 * 3600 * 24);
        if(inviteTable.getValidDay() > day)
            return null;
        return inviteTable;
    }

    public InviteTable CreateInviteTable(User user, String sportType, String location, String description,
                                         Date announceDate, Integer validDay, Integer number){
        InviteTable inviteTable = new InviteTable();
        inviteTable.setInviter(user);//维护外键
        inviteTable.setSportType(sportType);
        inviteTable.setLocation(location);
        inviteTable.setDescription(description);
        inviteTable.setAnnounceDate(announceDate);
        inviteTable.setValidDay(validDay);
        inviteTable.setNumber(number);

        //user.getInviteTables().add(inviteTable);//级联
        return inviteTable;
    }

    public InviteTable save(InviteTable inviteTable){
        return inviteRepository.save(inviteTable);
    }

    public List<InviteTable> findAll(){
        return valid(inviteRepository.findAll());
    }

    public List<InviteTable> findAllByInviterId(String uid){
        return inviteRepository.findAllByInviter_Id(uid);
    }

    public InviteTable findById(Integer vid){
        Optional<InviteTable> opu = inviteRepository.findById(vid);
        return valid(opu.get());
    }
    public void updateNumber(Integer vid){
        inviteRepository.updateNumber(0,vid);
    }
}