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
			@RequestParam(required = false) String field,
			@RequestParam(required = false) String search,
			Model model) {
		int row = 5;
		int startRow = (page - 1) * row;
		int rowCount = 0;
		List<QnaBoard> qnaList = null;
		if(field != null && !field.equals("")) {
			qnaList = questionMapper.selectQnaAll(startRow, row, field, search);	
			rowCount = questionMapper.selectQnaAllCount(field, search);
		} else {
			qnaList = questionMapper.selectQnaAll(startRow, row, null, null);
			rowCount = questionMapper.selectQnaAllCount(null, null);
		}
		Paging pageQnaAll = new Paging(page, rowCount, "/question/qnaList/", row);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("row", row);
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("page", page);
		model.addAttribute("pageQnaAll", pageQnaAll);
		System.out.println(qnaList);
		return "/question/qnaList";	
	};
	
	@GetMapping("/faqList/{page}/{faq_division_no}")
	public String faqList(
			@PathVariable int page, 
			@PathVariable int faq_division_no,
			@RequestParam(required = false) String field,
			@RequestParam(required = false) String search,
			Model model
			) {
		int row = 5;
		int startRow = (page - 1) * row;
		
		int rowCount = 0;
		int categoryCount = 0;
		
		List<FaqBoard> faqList = null; 
		List<FaqBoard> faqCategoryList = null;
		
		if(field != null && !field.equals("")) {
			faqList = questionMapper.selectFaqAll(startRow, row, field, search);
			faqCategoryList = questionMapper.selectFaqCategory(faq_division_no, startRow, row, field, search);
			rowCount = questionMapper.selectFaqAllCount(field, search);
			categoryCount = questionMapper.selectFaqCategoryCount(faq_division_no, field, search);
		} else {
			faqList = questionMapper.selectFaqAll(startRow, row, null, null);
			faqCategoryList = questionMapper.selectFaqCategory(faq_division_no, startRow, row, null, null);
			rowCount = questionMapper.selectFaqAllCount(null, null);
			categoryCount = questionMapper.selectFaqCategoryCount(faq_division_no, null, null);
		}
		
		Paging pageFaqAll = new Paging(page, rowCount, "/question/faqList/", row);
		Paging pageFaqCategory = new Paging(page, categoryCount, "/question/faqList/", row);
		
		model.addAttribute("faqList", faqList);
		model.addAttribute("faqCategoryList", faqCategoryList);
		model.addAttribute("row", row);
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("categoryCount", categoryCount);
		model.addAttribute("page", page);
		model.addAttribute("pageFaqAll", pageFaqAll);
		model.addAttribute("pageFaqCategory", pageFaqCategory);
		model.addAttribute("faq_devision_no", faq_division_no);
		
		System.out.println(faqList);
		System.out.println(faqCategoryList);
		
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
//	@GetMapping("/qnaForm")
//	public void newQna() {}
	
	@GetMapping("/insertQna.do")
	public void insertQna() {}
	@PostMapping("/insertQna.do")
	public String insertQna(QnaBoard qnaboard) {
		int insert=0;
		insert=questionMapper.insertQnaOne(qnaboard);
		if(insert>0) {
			return "redirect:/question/qnaList/1";
		} else {
			return "redirect:/question/insertQna.do";
		}
	}
}