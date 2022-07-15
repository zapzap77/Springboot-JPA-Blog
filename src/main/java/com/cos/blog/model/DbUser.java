package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User classが MYSQL にテーブル作る
//@DynamicInsert   insert시 null인 빌드를 제외시켜줌
public class DbUser {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // projectに連結されたDBのnumbering戦略をそう
	private int id; // sequence,auto_increment

	@Column(nullable = false, length = 30, unique = true)
	private String userName; // id

	@Column(nullable = false, length = 100) // hash
	private String password; // id

	@Column(nullable = false, length = 60)
	private String email;

	@Enumerated(EnumType.STRING)
	private RoleType role;

	@CreationTimestamp // 時間自動入力
	private Timestamp createDate;
}
