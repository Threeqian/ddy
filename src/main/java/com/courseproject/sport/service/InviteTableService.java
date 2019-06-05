package com.courseproject.sport.service;

import com.courseproject.sport.dao.InviteRepository;
import com.courseproject.sport.entity.inviteTable;
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
    List<inviteTable> avalid(List<inviteTable> list){
        List<inviteTable> validable = list;
        for(inviteTable i:validable){
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

    public boolean createNewInvite(inviteTable s){
        if(inviteRepository.save(s)!=null)
            return true;
        return false;
    }
    public List<inviteTable> findAll(){
        return avalid(inviteRepository.findAll());
    }

    public List<inviteTable> findBySportType(String sportType){
        return avalid(inviteRepository.findBySportType(sportType));
    }
}
