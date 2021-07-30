package com.example.hellopuppyreview.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellopuppyreview.domain.review.entity.Monitor;
import com.example.hellopuppyreview.domain.review.entity.MonitorDetail;
import com.example.hellopuppyreview.domain.review.enums.Status;
import com.example.hellopuppyreview.domain.review.repository.MonitorRepository;
import com.example.hellopuppyreview.domain.review.vo.MemberInfo;

import lombok.AllArgsConstructor;

//UI -> Controller -> Srevice
@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
	
	//@Autowired
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private final MonitorRepository monitorRepository;
	
	// @Test
	@GetMapping("/hello")
	public String getHello() {
		return "Welcome to my world";
	}
	// @Test 
	// @RequestParam => @GetMapping("read")에서 ?key=val 형태로 호출 시) 
	// @PathValiable => @PostMapping("delete/{idx}") /home/1 형태로 호출 시)
	@GetMapping("/helloParam")
	public String helloParam(@RequestParam("name") String name) {
		//log 출력
		logger.trace("TRACE 로그 출력");
		logger.debug("DEBUG 로그 출력");
		logger.info("INFO 로그 출력");
		logger.warn("WARN 로그 출력");
		logger.error("ERROR 로그 출력");
		
		return "Hello~~ " + name;
	}
	
	@GetMapping("/insertMonitor")
	public String insertMonitor() {
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
		
		return "OK~~ ";
	}
	
	
	
	//1. 모니터링데이터 전체 조회 -> 산책러id 기준으로 가져오는 것으로 바꿔야 함.
	// public ResponseEntity<List<Monitor>> findAllMonitorByWalkmanId(@PathVariable Long walkmanId) {
	//return  ResponseEntity.ok().body(monitorService.findAllMemberByTeamId(walkmanId));  
    // }
	// 호출) http://localhost:8080/review/monitor/all
	@GetMapping("/monitor/all")
	public List<Monitor> getAllMonitor() {
		return new ArrayList<Monitor>(monitorRepository.findAll());
	}
	
	
	// 2. 모니터링 데이터 (처음)등록
	
	// 3. 모니터링 리스트 
	
	// 4. 모니터링 상세 조회
	
	// 5. 후기 등록
	
	// 6. 후기 목록
	
	// 6. 후기 상세 조회
}
