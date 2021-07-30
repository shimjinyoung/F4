package com.example.hellopuppyreview.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hellopuppyreview.domain.review.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}
