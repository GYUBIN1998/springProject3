package com.group3.springProject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.group3.springProject.dto.Review;
import com.group3.springProject.dto.User;
import com.group3.springProject.mapper.ReviewMapper;
@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewMapper reviewMapper;
	 
	@GetMapping("/userReviewList/{userId}")
	public String UserReviewList(@PathVariable String userId,
								Review review,
								@SessionAttribute User loginUser,
								Model model) {
		if(loginUser!=null) {
			List<Review> reviews=reviewMapper.selectByUserId(userId);
			model.addAttribute("reviews",reviews);
			model.addAttribute("userId",userId);
		}
		return"/review/userReviewList";
		
	}
	@GetMapping("/userReviewUpdate/{reviewNo}")
	public String UserReviewUpdate(
			@PathVariable int reviewNo,
			Review review,
			Model model,
			@SessionAttribute User loginUser
			) {
		if(loginUser!=null) {
			review=reviewMapper.selectByReviewNo(reviewNo);
			model.addAttribute(review);
		}
		return"/review/userReviewUpdate";
	}
	@PostMapping("/userReviewUpdate.do")
	public String UserReviewUpdate(
			Review review
			) {
		int update=0;
		update=reviewMapper.updateByReviewNo(review);
		System.out.println(update);
		if(update>0) {
			return "redirect:/review/userReviewList/"+review.getUser_id();
		}else {
			return "redirect:/review/userReviewUpdate/"+review.getReview_no();
		}
	}
	
}