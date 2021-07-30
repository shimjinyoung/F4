package com.example.hellopuppyreview.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hellopuppyreview.domain.review.entity.MonitorDetail;

@Repository
public interface MonitorDetailRepository extends JpaRepository<MonitorDetail, Long> {

}
