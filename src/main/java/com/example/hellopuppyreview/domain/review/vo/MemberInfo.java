package com.example.hellopuppyreview.domain.review.vo;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MemberInfo {
	private Long member_id;
	private String member_mobile;
	private String member_email;
	private String petName;
	private String petGender;
	private Long petAge;
	
}

