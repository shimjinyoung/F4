package com.example.hellopuppyreview.domain.review.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.hellopuppyreview.domain.review.vo.MemberInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude="monitorDetailList")
@Table(name="monitor")
public class Monitor {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="revId")
	private Long revId;
	
	@Column(name="walkmanId")
	private Long walkmanId;

	@Column(name="startDt")
	private Date startDt;
	
	@Column(name="endDt")
	private Date endDt;
	
	// MemberInfo ValueObject 추가
	// VO 내재화
	@Column(name="memberInfo")
	@Embedded
	private MemberInfo memberInfo;
	
	// 양방향 매핑을 해서 Monitor조회 시 detail까지 같이 조회하려고..
	@OneToMany(mappedBy="monitor", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<MonitorDetail> monitorDetailList = new ArrayList<MonitorDetail>(); 
	
}
