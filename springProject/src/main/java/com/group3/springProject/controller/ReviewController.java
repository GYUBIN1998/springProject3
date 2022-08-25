package com.group3.springProject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.group3.springProject.dto.Review;
import com.group3.springProject.mapper.ReviewMapper;
@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewMapper reviewMapper;
	 
	@GetMapping("/reviewList/{userId}")
	public String UserReviewList(@PathVariable String userId , Model model) {
		List<Review> reviews=reviewMapper.selectByUserId(userId);
		model.addAttribute("reviews",reviews);
		System.out.println(reviews);
		return"/review/reviewList";
	}
}