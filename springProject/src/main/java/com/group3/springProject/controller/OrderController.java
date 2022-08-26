package com.group3.springProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.group3.springProject.dto.OrderSheet;
import com.group3.springProject.mapper.OrderMapper;
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderMapper orderMapper;
	//결제페이지 회원 정보 불러오기
	@GetMapping("/orderPage/{userId}")
	public String orderPageDetail(
			@PathVariable String userId,
			Model model) {
		//System.out.println(userId);
		OrderSheet ordersheet=orderMapper.selectByUserId(userId);
		model.addAttribute("ordersheet",ordersheet);
		String[] userEmail=ordersheet.getUser().getUser_email().split("@");
		String userEmailId=userEmail[0].toString();
		String userEmailAdr=userEmail[1].toString();
		model.addAttribute("userEmailId",userEmailId);
		model.addAttribute("userEmailAdr",userEmailAdr);
		String[] userPhone=ordersheet.getUser().getUser_phone().split("-", 3);
		String userPhoneMid=userPhone[1].toString();
		String userPhoneLast=userPhone[2].toString();
		model.addAttribute("userPhoneMid",userPhoneMid);
		model.addAttribute("userPhoneLast",userPhoneLast);
		//System.out.println(userEmailAdr);
		//System.out.println(userPhoneLast);
		String prodName=ordersheet.getProduct().getProd_name();
		System.out.println(prodName);
		model.addAttribute("prodName",prodName);
		return"/order/orderPage";
	}

	
	//결제목록
	@GetMapping("/orderList/{orderListNo}")
	public String orderList(@PathVariable String orderListNo, Model model) {
		return "/order/orderList";
	}
}
