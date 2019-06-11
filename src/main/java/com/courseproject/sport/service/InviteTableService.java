package com.courseproject.sport.service;

import com.courseproject.sport.dao.InviteRepository;
import com.courseproject.sport.entity.InviteTable;
import com.courseproject.sport.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class InviteTableService {

    @Autowired
    private InviteRepository inviteRepository;

    //返回有效日期的结果集
    List<InviteTable> valid(List<InviteTable> list){
        List<InviteTable> validable = list;
        for(InviteTable i:validable){
            try {
                if(new SimpleDateFormat().parse(i.getValidDate()).before(new Date())){
                    validable.remove(i);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return validable;
    }

    InviteTable valid(InviteTable inviteTable){
        try {
            if(new SimpleDateFormat().parse(inviteTable.getValidDate()).before(new Date())){
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return inviteTable;
    }

    public InviteTable CreateInviteTable(User user, String sportType, String location, String description,
                                         String announceDate, String validDate, Integer number){
        InviteTable inviteTable = new InviteTable();
        inviteTable.setInviter(user);//维护外键
        inviteTable.setSportType(sportType);
        inviteTable.setLocation(location);
        inviteTable.setDescription(description);
        inviteTable.setAnnounceDate(announceDate);
        inviteTable.setValidDate(validDate);
        inviteTable.setNumber(number);

        user.getInviteTables().add(inviteTable);//级联
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
    public void updateNumber(Integer number,Integer vid){
        inviteRepository.updateNumber(number,vid);
    }
}