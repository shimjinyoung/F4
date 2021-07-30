package com.example.hellopuppyreview.domain.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hellopuppyreview.domain.review.entity.Monitor;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
	List<Monitor> findAllById(Long id);
}
