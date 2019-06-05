package com.courseproject.sport.dao;

import com.courseproject.sport.entity.InviteRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InviteRecordRepository extends JpaRepository<InviteRecord, String> {
    List<InviteRecord> findAll();
    List<InviteRecord> findAllByUserId(String uid);
    InviteRecord save(InviteRecord inviteRecord);
}
