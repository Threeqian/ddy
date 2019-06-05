package com.courseproject.sport.dao;

import com.courseproject.sport.entity.inviteTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InviteRepository extends JpaRepository<inviteTable,Integer> {
    List<inviteTable> findAll();
    List<inviteTable> findBySportType(String sportType);

    @Override
    inviteTable save(inviteTable s);
}
