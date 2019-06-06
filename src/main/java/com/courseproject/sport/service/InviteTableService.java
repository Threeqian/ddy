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
<<<<<<< Updated upstream
    List<InviteTable> avalid(List<InviteTable> list){
=======
    List<InviteTable> valid(List<InviteTable> list){
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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
=======
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

    public InviteTable save(InviteTable inviteTable){
        return inviteRepository.save(inviteTable);
    }

    public List<InviteTable> findAll(){
        return valid(inviteRepository.findAll());
    }

    public InviteTable findById(Integer vid){
        Optional<InviteTable> opu = inviteRepository.findById(vid);
        return valid(opu.get());
    }
    public void updateNumber(Integer number,Integer vid){
        inviteRepository.updateNumber(number,vid);
>>>>>>> Stashed changes
    }
}
