package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity // User classが MYSQL にテーブル作る
public class User {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // projectに連結されたDBのnumbering戦略をそう
	private int id; // sequence,auto_increment

	@Column(nullable = false, length = 30)
	private String userName; // id

	@Column(nullable = false, length = 100) // 123456 => hash
	private String password;

	@Column(nullable = false, length = 50)
	private String email;

	@ColumnDefault("'user'")
	private String role;

	@CreationTimestamp // 時間自動入力
	private Timestamp createDate;
}
