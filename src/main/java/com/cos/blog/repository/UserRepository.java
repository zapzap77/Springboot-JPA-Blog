package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.DbUser;

//DAO
//自動でBIN に登録される
//@Repository 
public interface UserRepository extends JpaRepository<DbUser, Integer> {

}
