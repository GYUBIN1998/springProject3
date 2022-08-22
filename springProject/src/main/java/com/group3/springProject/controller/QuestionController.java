package com.group3.springProject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String qnaList(
			@PathVariable int page,
			Model model) {
		int row = 5;
		int startRow = (page - 1) * row;
		int rowCount = questionMapper.selectQnaAllCount();
		Paging pageQnaAll = new Paging(page, rowCount, "/question/qnaList/", row);
		List<QnaBoard> qnaList = questionMapper.selectQnaAll(startRow, row);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("row", row);
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("page", page);
		model.addAttribute("pageQnaAll", pageQnaAll);
		System.out.println(qnaList);
		return "/question/qnaList";	
	};
	
	@GetMapping("/faqList/{page}/{faq_devision_no}")
	public String faqList(
			@PathVariable int page, 
			@PathVariable int faq_devision_no,
			Model model
			) {
		int row = 5;
		int startRow = (page - 1) * row;
		
		int rowCount = questionMapper.selectFaqAllCount();
		int categoryCount = questionMapper.selectFaqCategoryCount(faq_devision_no);
		
		Paging pageFaqAll = new Paging(page, rowCount, "/question/faqList/", row);
		Paging pageFaqCategory = new Paging(page, categoryCount, "/question/faqList/", row);
		
		List<FaqBoard> faqList = questionMapper.selectFaqAll(startRow, row);
		List<FaqBoard> faqCategoryList = questionMapper.selectFaqCategory(faq_devision_no, startRow, row);
		
		model.addAttribute("faqList", faqList);
		model.addAttribute("faqCategoryList", faqCategoryList);
		model.addAttribute("row", row);
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("categoryCount", categoryCount);
		model.addAttribute("page", page);
		model.addAttribute("pageFaqAll", pageFaqAll);
		model.addAttribute("pageFaqCategory", pageFaqCategory);
		model.addAttribute("faq_devision_no", faq_devision_no);
		
		System.out.println(faqList);
		System.out.println(faqCategoryList);
		
		return "/question/faqList";	
	}
}
