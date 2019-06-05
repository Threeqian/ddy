package com.courseproject.sport.service;

import com.courseproject.sport.dao.InviteRepository;
import com.courseproject.sport.entity.InviteTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class InviteTableService {

    @Autowired
    private InviteRepository inviteRepository;

    //返回有效日期的结果集
    List<InviteTable> avalid(List<InviteTable> list){
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

    public boolean createNewInvite(InviteTable s){
        if(inviteRepository.save(s)!=null)
            return true;
        return false;
    }
    public List<InviteTable> findAll(){
        return avalid(inviteRepository.findAll());
    }

    public List<InviteTable> findBySportType(String sportType){
        return avalid(inviteRepository.findBySportType(sportType));
    }
}
