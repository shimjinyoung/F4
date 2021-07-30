package com.example.hellopuppyreview.domain.review.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="review")
public class Review {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="rev_id")
	private Long rev_id;
	
	@Column(name="walkman_Id")
	private Long walkman_Id;
	
	@Column(name="score")
	private Long score;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="create_dt")
	private Date create_dt;
	
	@Column(name="update_dt")
	private Date update_dt;
	
}
