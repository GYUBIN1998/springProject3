package com.group3.springProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.group3.springProject.dto.Review;

//com.group3.springProject.mapper.ReviewMapper

@Mapper
public interface ReviewMapper {
	List<Review> selectAll();
	List<Review> selectByUserId(String userId);
	Review selectByReviewNo(int reviewNo);
	int updateByReviewNo(Review review);
	
}