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
@RequestMapping("/review")
@AllArgsConstructor
public class HelloPuppyReview {
	
//	private final Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Autowired
//	private final MonitorRepository monitorRepository;

	
	//1. 모니터링데이터 전체 조회 -> 산책러id 기준으로 가져오는 것으로 바꿔야 함.
	
	// 2. 모니터링 데이터 (처음)등록
	
	// 3. 모니터링 리스트 
	
	// 4. 모니터링 상세 조회
	
	// 5. 후기 등록
	
	// 6. 후기 목록
	
	// 6. 후기 상세 조회
	
	
}
