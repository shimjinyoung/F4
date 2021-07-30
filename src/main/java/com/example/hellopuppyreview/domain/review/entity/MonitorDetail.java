package com.example.hellopuppyreview.domain.review.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.hellopuppyreview.domain.review.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude="monitor")
@Table(name="monitorDetail")
public class MonitorDetail {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="gps")
	private String gps;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="create_dt")
	private Date create_dt;
	
	@Column(name="update_dt")
	private Date update_dt;
	
	// status Enum 추가 
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	// Monitor Enttity JoinColumn 추가
	// Team 엔티티와 id relation
	// nullable = false > 조인컬럼은 default가 outer join이라, 성능상 inner join으로 변경하기 위해
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "monitor_id", nullable=false)
	private Monitor monitor;
	
	// Monitor 정보를 같이 수정할 경우.. 
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	    monitor.getMonitorDetailList().add(this); 
	}
	 
	
}
