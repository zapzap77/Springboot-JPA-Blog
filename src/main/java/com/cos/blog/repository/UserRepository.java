package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.DbUser;

//DAO
//自動でBIN に登録される
//@Repository 
public interface UserRepository extends JpaRepository<DbUser, Integer> {

	// JPA Naming query
	// select * from DbUser where userName = ? AND password = ?
	DbUser findByUserNameAndPassword(String userName, String password);

//	@Query(value = "select * from DbUser where userName = ?1 AND password = ?2", nativeQuery = true )
//	DbUser login(String userName, String password);
}
