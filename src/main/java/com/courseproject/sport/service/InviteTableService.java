package com.courseproject.sport.service;

import com.courseproject.sport.dao.InviteRepository;
import com.courseproject.sport.entity.InviteTable;
import com.courseproject.sport.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class InviteTableService {

    @Autowired
    private InviteRepository inviteRepository;
    private UserService userService;

    //返回有效日期的结果集
    List<InviteTable> valid(List<InviteTable> list) {
        List<InviteTable> validatable = new ArrayList<>();
        Date date = new Date(new java.util.Date().getTime());
        for (InviteTable i : list) {
            long day = (date.getTime() - i.getAnnounceDate().getTime()) / (1000 * 3600 * 24);
            if (i.getValidDay() >= day) {
                validatable.add(i);
            }
        }
        return validatable;
    }

    InviteTable valid(InviteTable inviteTable) {
        Date date = new Date(new java.util.Date().getTime());
        long day = (date.getTime() - inviteTable.getAnnounceDate().getTime()) / (1000 * 3600 * 24);
        if (inviteTable.getValidDay() < day)
            return null;
        return inviteTable;
    }

    public InviteTable CreateInviteTable(String userId, String sportType, String location, String description,
                                         Date announceDate, Integer validDay, Integer number) {
        InviteTable inviteTable = new InviteTable();
        inviteTable.setInviterId(userId);//维护外键
        inviteTable.setSportType(sportType);
        inviteTable.setLocation(location);
        inviteTable.setDescription(description);
        inviteTable.setAnnounceDate(announceDate);
        inviteTable.setValidDay(validDay);
        inviteTable.setNumber(number);
        inviteTable.setIs_evaluate(0);
        return inviteTable;
    }

    public InviteTable save(InviteTable inviteTable) {
        return inviteRepository.save(inviteTable);
    }

    /**
     *
     * @return 返回20条
     */
    public List<InviteTable> findAll(int start,int end) {
        List<InviteTable> list = valid(inviteRepository.findAll());
        if(list.size()<end)
            if(start == 0)
                return list;
            else
                return list.subList(start,list.size());
        return list.subList(start,end);
    }

    public List<InviteTable> findAllByInviterId(String uid) {
        List<InviteTable> list = inviteRepository.findAllByInviterId(uid);
        for(InviteTable inviteTable:list){
            inviteTable.setUser(userService.findUser(inviteTable.getInviterId()));
        }
        return list;
    }

    public List<InviteTable> findAllByType(String type,int start,int end) {
        //return valid(inviteRepository.findBySportType(type));
        List<InviteTable> list = valid(inviteRepository.findBySportType(type));
        if(list.size()<end)
            if(start == 0)
                return list;
            else
                return list.subList(start,list.size());
        return list.subList(start,end);
    }

    public InviteTable findById(Integer vid) {
        Optional<InviteTable> opu = inviteRepository.findById(vid);
        //return valid(opu.get());
        return opu.get();
    }
}