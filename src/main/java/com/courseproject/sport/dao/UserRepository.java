package com.courseproject.sport.dao;

import com.courseproject.sport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
    List<User> findAll();

    @Override
    boolean existsById(String uid);

    User save(User user);

//    @Query("select user_openid,user_introdunction,user_name,user_evaluate_score,user_score from user_info")
//    List<User> find();

//
//    @Query(value = "update user_info set user_info .score= ?1 where user_info.id = ?2",nativeQuery = true)
//    void updateScore(Double score,String uid);
}