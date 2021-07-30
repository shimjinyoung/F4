package com.example.hellopuppyreview;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hellopuppyreview.domain.review.entity.Monitor;
import com.example.hellopuppyreview.domain.review.entity.MonitorDetail;
import com.example.hellopuppyreview.domain.review.enums.Status;
import com.example.hellopuppyreview.domain.review.repository.MonitorRepository;
import com.example.hellopuppyreview.domain.review.vo.MemberInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HellopuppyJPATest {
	
	//@Autowired
	//private MockMvc mockMvc;
	
	@Autowired
	private MonitorRepository monitorRepository;
	
	// Monitor 테이블에 단건 insert (OneToMany : Monitor -> MonitorDetail)
	@Test  
	void MonitorOneInsert() throws Exception {
		
		// MemberVO 정보 
		MemberInfo member = new MemberInfo();
		member.setMember_email("wrk94@naver.com");
		member.setMember_id(1L);
		member.setMember_mobile("01000022222");
		member.setPetAge(9L);
		member.setPetGender("MALE");
		member.setPetName("Tory");
		
		// MonitorDetail 정보(배열)
		List<MonitorDetail> detailList = new ArrayList<MonitorDetail>(); 
		MonitorDetail detail1 = new MonitorDetail();
		detail1.setComment("첫 번째 Detail 정보");
		detail1.setCreate_dt(new Date());
		detail1.setUpdate_dt(new Date());
		detail1.setGps("00000");
		detail1.setPhoto("/222/3333/444");
		detail1.setStatus(Status.START);
		
		MonitorDetail detail2 = new MonitorDetail();
		detail2.setComment("두번째 Detail 정보");
		detail2.setCreate_dt(new Date());
		detail2.setUpdate_dt(new Date());
		detail2.setGps("00000");
		detail2.setPhoto("/222/3333/444");
		detail2.setStatus(Status.START);
		
		
		Monitor monitor = new Monitor();
		monitor.setEndDt(new Date());
		monitor.setStartDt(new Date());
		monitor.setRevId(1L);
		monitor.setWalkmanId(1L);
		monitor.setMemberInfo(member);
		monitor.setMonitorDetailList(null);
		monitor.setMonitorDetailList(detailList);
		
		
		// 순환 참조되는 형태라.. detail정보를 monitor가 생성된 이후에 set한다.
		detail1.setMonitor(monitor);
		detail2.setMonitor(monitor);
		detailList.add(detail1);
		detailList.add(detail2);
		
		monitorRepository.save(monitor);
		
	}
}
