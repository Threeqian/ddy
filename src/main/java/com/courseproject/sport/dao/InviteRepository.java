package com.courseproject.sport.dao;

import com.courseproject.sport.entity.InviteTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InviteRepository extends JpaRepository<InviteTable,Integer> {
<<<<<<< Updated upstream
    List<InviteTable> findAll();
    List<InviteTable> findBySportType(String sportType);

    @Override
    InviteTable save(InviteTable s);
=======

    List<InviteTable> findAll();
    Optional<InviteTable> findById(Integer vid);

    @Override
    InviteTable save(InviteTable s);

    @Modifying
    @Query(value = "update invite_info set invite_info.number = :num where invite_info.id = :vid",nativeQuery = true)
    void updateNumber(@Param(value = "num") Integer number, @Param(value = "vid") Integer vid);
>>>>>>> Stashed changes
}
