package com.courseproject.sport.dao;

import com.courseproject.sport.entity.AcceptRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcceptRecordRepository extends JpaRepository<AcceptRecord, String> {
    List<AcceptRecord> findAll();
    //返回用户所有的接受邀请记录List
    List<AcceptRecord> findAllByUserId(String uid);
    AcceptRecord save(AcceptRecord arecord);
}
