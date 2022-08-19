package com.group3.springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group3.springProject.mapper.TestMapper;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestMapper testMapper;
	
	@GetMapping("/userUpdate")
	public void detail() {}
	
	@GetMapping("/qnaForm")
	public void newQna() {}

}
