package com.courseproject.sport.dao;

import com.courseproject.sport.entity.InviteTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InviteRepository extends JpaRepository<InviteTable,Integer> {

    List<InviteTable> findAll();
    Optional<InviteTable> findById(Integer vid);
    List<InviteTable> findAllByInviterId(String uid);
    List<InviteTable> findBySportType(String type);
    @Override
    InviteTable save(InviteTable s);
}
