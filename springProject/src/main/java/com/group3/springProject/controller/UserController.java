package com.group3.springProject.controller;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.group3.springProject.dto.IdCheck;
import com.group3.springProject.dto.PhoneCheck;
import com.group3.springProject.dto.EmailCheck;
import com.group3.springProject.dto.User;
import com.group3.springProject.dto.IdCheck;
import com.group3.springProject.mapper.UserMapper;
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	//회원정보 디테일
	@GetMapping("/detail/{user_id}")
	public String detail(@PathVariable String user_id, Model model) {
		User user=userMapper.selectUserId(user_id);
		model.addAttribute(user);
		System.out.println(user);
		
		return "/user/detail";
	};
	
	//회원정보 수정
	@PostMapping("/update.do")
	public String update(User user) {
		int update=0;
		try {
			update=userMapper.updateOne(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(update>0) {
			return "redirect:/";
		} else {
			return "redirect:/user/detail/"+user.getUser_id();
		}
	};
	
//	회원가입
	@GetMapping("/signup")
	public void signup() {};
	
	@GetMapping("/idCheck/{user_id}")
	public @ResponseBody IdCheck idCheck(@PathVariable String user_id) {
		IdCheck idCheck = new IdCheck();
		User user = userMapper.selectUserId(user_id);
		if(user != null) {
			idCheck.idCheck = true;
			idCheck.user = user;
		}
		return idCheck;	
	}
	
	@GetMapping("/emailCheck/{user_email}")
	public @ResponseBody EmailCheck emailCheck(@PathVariable String user_email) {
		EmailCheck emailCheck = new EmailCheck();
		User user = userMapper.selectUserEmail(user_email);
		if(user != null) {
			emailCheck.emailCheck = true;
			emailCheck.user = user;
		}
		return emailCheck;	
	}
	
	@GetMapping("/phoneCheck/{user_phone}")
	public @ResponseBody PhoneCheck phoneCheck(@PathVariable String user_phone) {
		PhoneCheck phoneCheck = new PhoneCheck();
		User user = userMapper.selectUserPhone(user_phone);
		if(user != null) {
			phoneCheck.phoneCheck = true;
			phoneCheck.user = user;
		}
		return phoneCheck;	
	}
	
	@PostMapping("/signup.do")
	public String signup(User user) {
		int signup = 0;
		try {
			signup = userMapper.userSignup(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user);
		System.out.println("회원가입 성공 : " + signup);
		if(signup > 0) {
			return "redirect:/";
		} else {		
			return "redirect:/user/signup";
		}		
	}
	
// 로그인	
	@GetMapping("/login")
	public void login() {}
	@PostMapping("/login.do")
	public String login(
			@RequestParam(value = "user_id")String user_id,
			@RequestParam(value = "user_pw")String user_pw,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception{
		User user = null;
		try {
			user=userMapper.selectPwOne(user_id, user_pw);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(user);
		if(user != null) {
			session.setAttribute("loginUser", user);
			return "redirect:/";
		}else {
			response.setContentType("text/html; charset=UTF-8");			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('아이디 또는 비밀번호를 확인해주세요'); history.go(-1); </script>");
			out.flush();
			return "redirect:/user/login";
		}
	}

	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
	
	@GetMapping("/findId")
	public void findId() {}
	
	@PostMapping("/findId.do")
	public String findId(
			@RequestParam(value = "user_name")String user_name,
			@RequestParam(value = "user_email")String user_email,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception{
		User findId = null;
		try {
			findId=userMapper.selectFindId(user_name, user_email);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(findId);
		if(findId != null) {
			response.setContentType("text/html; charset=UTF-8");			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('찾았습니다');</script>");
			out.flush();
			return "redirect:/user/login";
		}else {
			response.setContentType("text/html; charset=UTF-8");			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('없는 회원입니다.'); history.go(-1); </script>");
			out.flush();
			return "redirect:/user/login";
		}
	}
	

// 장바구니
	@GetMapping("/cart")
	public String cart() {
		return "/user/cart";
	}
}
