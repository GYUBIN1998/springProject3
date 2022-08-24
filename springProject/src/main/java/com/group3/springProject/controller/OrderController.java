package com.group3.springProject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.group3.springProject.dto.OrderSheet;
import com.group3.springProject.dto.User;
import com.group3.springProject.mapper.OrderMapper;
import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderMapper orderMapper;
	//결제페이지 회원 정보 불러오기
	@GetMapping("/orderPage/{userId}")
	public String orderPageDetail(@PathVariable String userId, Model model) {
		//System.out.println(userId);
		OrderSheet ordersheet=orderMapper.selectByUserId(userId);
		String[] userEmail=ordersheet.getUser().getUser_email().split("@");
		String userEmailId=userEmail[0].toString();
		String userEmailAdr=userEmail[1].toString();
		model.addAttribute("ordersheet",ordersheet);
		model.addAttribute("userEmailId",userEmailId);
		model.addAttribute("userEmailAdr",userEmailAdr);
		String[] userPhone=ordersheet.getUser().getUser_phone().split("-", 3);
		String userPhoneMid=userPhone[1].toString();
		String userPhoneLast=userPhone[2].toString();
		model.addAttribute("userPhoneMid",userPhoneMid);
		model.addAttribute("userPhoneLast",userPhoneLast);
		//System.out.println(userEmailAdr);
		//System.out.println(userPhoneLast);
		return"/order/orderPage";
	}
}