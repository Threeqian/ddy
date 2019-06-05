package com.courseproject.sport.dao;

import com.courseproject.sport.entity.InviteTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InviteRepository extends JpaRepository<InviteTable,Integer> {
    List<InviteTable> findAll();
    List<InviteTable> findBySportType(String sportType);

    @Override
    InviteTable save(InviteTable s);
}
