package com.group3.springProject.controller;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.group3.springProject.dto.OrderList;
import com.group3.springProject.dto.OrderSheet;
import com.group3.springProject.dto.Product;
import com.group3.springProject.dto.User;
import com.group3.springProject.mapper.OrderMapper;
import com.group3.springProject.mapper.ProductMapper;
import com.group3.springProject.mapper.UserMapper;
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	UserMapper userMapper;
	
		@GetMapping("/orderPage/{prodId}")
	public String orderPageDetail(
			@PathVariable String prodId,
			@SessionAttribute User loginUser,
			Model model) {
		//System.out.println(userId);
		if(loginUser!=null) {
			System.out.println(loginUser);
			//로그인회원정보
			String orderUserName=loginUser.getUser_name();
			model.addAttribute("orderUserName",orderUserName);
			String orderUserId=loginUser.getUser_id();
			model.addAttribute("orderUserId",orderUserId);
			String[] userEmail=loginUser.getUser_email().split("@");
			String userEmailId=userEmail[0].toString();
			String userEmailAdr=userEmail[1].toString();
			model.addAttribute("userEmailId",userEmailId);
			model.addAttribute("userEmailAdr",userEmailAdr);
			String[] userPhone=loginUser.getUser_phone().split("-", 3);
			String userPhoneMid=userPhone[1].toString();
			String userPhoneLast=userPhone[2].toString();
			model.addAttribute("userPhoneMid",userPhoneMid);
			model.addAttribute("userPhoneLast",userPhoneLast);
			String userPostecode=loginUser.getUser_addr_postcode();
			String userAddrMain=loginUser.getUser_addr_main();
			String userAddrDetail=loginUser.getUser_addr_detail();
			String userAddrExtra=loginUser.getUser_addr_extra();
			model.addAttribute("userPostecode",userPostecode);
			model.addAttribute("userAddrMain",userAddrMain);
			model.addAttribute("userAddrDetail",userAddrDetail);
			model.addAttribute("userAddrExtra",userAddrExtra);
			//상품
			Product orderProd=productMapper.selectFindOne(prodId);
			String prodName=orderProd.getProd_name();
			String orderProdId=orderProd.getProd_id();
			int prodPrice=orderProd.getProd_price();
			model.addAttribute("prodName",prodName);
			model.addAttribute("prodPrice",prodPrice);
			model.addAttribute("orderProdId",orderProdId);
			LocalDateTime orderTime=LocalDateTime.now();
			model.addAttribute("orderTime",orderTime);
				}
			return "/order/orderPage";
			
		}
		
	//결제정보를 insert
	@GetMapping("/orderPageInfo")
	public void orderInsert() {}
	@PostMapping("/orderSuccess.do")
	public String orderInsert(OrderSheet orderSheet) {
		int orderInsert=0;
		try {
			orderInsert=orderMapper.insertOrderInfo(orderSheet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(orderSheet);
		System.out.println("결제성공: "+ orderInsert);
		if(orderInsert>0) {
			return "redirect:/order/orderSuccess";
		}else {
			return "redirect:/order/orderPage/{prodId}";
		}
	}
		
	
	//결제목록
	@GetMapping("/orderList/{orderListNo}")
	public String orderList(@PathVariable String orderListNo, Model model) {
		return "/order/orderList";
	}
}
