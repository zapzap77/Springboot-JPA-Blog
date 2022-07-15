package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob 
	private String content;
	
	@ColumnDefault("0")
	private int count; //照会数
	 
	@ManyToOne(fetch = FetchType.EAGER) //Many = Board, One = User    /  eager - 必ず持ってくる、 lagy - 必要なら
	@JoinColumn(name="userID")
	private DbUser user; //DBはオブジェクトが保存できない、FK,JAVAはできる
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //mappedBy - 連関関係の主じゃない(FKじゃない)DBにColumn作ったらだめ
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
