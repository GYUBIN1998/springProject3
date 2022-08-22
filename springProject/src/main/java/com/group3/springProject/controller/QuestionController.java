package com.group3.springProject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group3.springProject.dto.FaqBoard;
import com.group3.springProject.dto.Paging;
import com.group3.springProject.dto.QnaBoard;
import com.group3.springProject.mapper.QuestionMapper;
@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionMapper questionMapper;
	
	@GetMapping("/qnaList/{page}")
	public String qnaList(@PathVariable int page, Model model) {
		int row = 5;
		int startRow = (page - 1) * row;
		int rowCount = questionMapper.selectQnaAllCount();
		Paging paging = new Paging(page, rowCount, "/question/qnaList/", row);
		List<QnaBoard> qnaList = questionMapper.selectQnaAll(startRow, row);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("row", row);
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("page", page);
		model.addAttribute("paging", paging);
		System.out.println(qnaList);
		return "/question/qnaList";	
	};
	
	@GetMapping("/faqList/{page}")
	public String faqList(@PathVariable int page, Model model) {
		int row = 5;
		int startRow = (page - 1) * row;
		int rowCount = questionMapper.selectFaqAllCount();
		Paging paging = new Paging(page, rowCount, "/question/faqList/", row);
		List<FaqBoard> faqList = questionMapper.selectFaqAll(startRow, row);
		model.addAttribute("faqList", faqList);
		model.addAttribute("row", row);
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("page", page);
		model.addAttribute("paging", paging);
		System.out.println(faqList);
		return "/question/faqList";	
	}
	
	@GetMapping("/qnaDetail/{qnaboardNo}")
	public String qnaDetail(@PathVariable int qnaboardNo, Model model) {
		//System.out.println(qnaboardNo);
		QnaBoard qnaBoard=questionMapper.selectQnaFindOne(qnaboardNo);
		model.addAttribute(qnaBoard);
		System.out.println(qnaBoard);
		return "/question/qnaDetail";
	}
}
