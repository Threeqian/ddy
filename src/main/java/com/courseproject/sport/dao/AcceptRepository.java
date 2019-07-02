package com.courseproject.sport.dao;

import com.courseproject.sport.entity.AcceptTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcceptRepository extends JpaRepository<AcceptTable, Integer> {
    List<AcceptTable> findAll();
//    List<AcceptTable> findAllByInviteId(Integer vid);
//    List<AcceptTable> findAllByAccepterId(String uid);
    List<AcceptTable> findAllByInviteId(Integer vid);
    List<AcceptTable> findAllByAccepterId(String uid);
    AcceptTable save(AcceptTable acceptTable);
}
