package com.group3.springProject.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.group3.springProject.dto.FaqBoard;
import com.group3.springProject.dto.Paging;
import com.group3.springProject.dto.QnaBoard;
import com.group3.springProject.dto.User;
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
		
		if(field != null && !field.equals("")) { // 검색
			qnaList = questionMapper.selectQnaAll(startRow, row, field, search);	
			rowCount = questionMapper.selectQnaAllCount(field, search);
		} else { // 검색(x)
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
	
	@GetMapping("/faqList/{faq_division_no}/{page}")
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
		
		if(field != null && !field.equals("")) { // 검색
			// faq 전체 검색
			faqList = questionMapper.selectFaqAll(startRow, row, field, search);
			rowCount = questionMapper.selectFaqAllCount(field, search);
			
			// faq 카테고리 선택 후 검색
			faqCategoryList = questionMapper.selectFaqCategory(faq_division_no, startRow, row, field, search);
			categoryCount = questionMapper.selectFaqCategoryCount(faq_division_no, field, search);
		} else { // 검색(x)
			// faq 전체 출력
			faqList = questionMapper.selectFaqAll(startRow, row, null, null);
			rowCount = questionMapper.selectFaqAllCount(null, null);
			
			// faq 카테고리 선택 후 출력
			faqCategoryList = questionMapper.selectFaqCategory(faq_division_no, startRow, row, null, null);
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
	
	//qna detail : 문의 내용 확인
	@GetMapping("/qnaDetail/{qnaboardNo}")
	public String qnaDetail(@PathVariable int qnaboardNo, Model model) {
		//System.out.println(qnaboardNo);
		QnaBoard qnaBoard=questionMapper.selectQnaFindOne(qnaboardNo);
		model.addAttribute(qnaBoard);
		System.out.println(qnaBoard);
		return "/question/qnaDetail";
	}
	
	//qna insert : 문의 등록
	@GetMapping("/insertQna.do")
	public String insertQna(HttpSession session) {
		if(session.getAttribute("loginUser")!=null) {
			return "/question/insertQna";
		}else {
			return "redirect:/user/login.do";
		}
	}
	@PostMapping("/insertQna.do")
	public String insertQna(
			QnaBoard qnaBoard, 
			HttpSession session) {
		int insert=0;
		if(session.getAttribute("loginUser")!=null) {
			try {
				insert=questionMapper.insertQnaOne(qnaBoard);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(insert>0) {
				return "redirect:/question/qnaList/1";
			} else {
				return "redirect:/question/insertQna.do";
			}
		} else {
			return "redirect:/user/login.do";
			
		}
	}
	
	//qna update : 문의 수정
	@GetMapping("/updateQna/{qnaboardNo}")
	public String updateQna(
			@PathVariable int qnaboardNo, 
			Model model, 
			HttpSession session) {
		QnaBoard qnaBoard=questionMapper.selectQnaFindOne(qnaboardNo);
		Object loginUser_obj=session.getAttribute("loginUser");
		if(loginUser_obj!=null && ((User)loginUser_obj).getUser_id().equals(qnaBoard.getUser().getUser_id())) {
			model.addAttribute(qnaBoard);
			System.out.println(qnaBoard);
			return "/question/updateQna";
		} else {
			return "redirect:/user/login.do";
		}
	}
	@PostMapping("updateQna.do")
	public String updateQna(
			QnaBoard qnaBoard, 
			HttpSession session) {
		int update=0;
		Object loginUser_obj=session.getAttribute("loginUser");
		if(loginUser_obj!=null && ((User)loginUser_obj).getUser_id().equals(qnaBoard.getUser().getUser_id())) {
			try {
				update=questionMapper.updateQnaOne(qnaBoard);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(update>0) {
				return "redirect:/question/qnaDetail/"+qnaBoard.getQnaboard_no();
			} else {
				return "redirect:/question/updateQna/"+qnaBoard.getQnaboard_no();
			}
		} else {
			return "redirect:/user/login.do";
		}
	}
	
	//qna delete : 문의 삭제
	@GetMapping("/deleteQna/{qnaboardNo}/{userId}")
	public String delete(
			@PathVariable int qnaboardNo, 
			@PathVariable String userId, 
			@SessionAttribute(name = "loginUser",required = false) User loginUser) {
		int delete=0;
		if(loginUser!=null && loginUser.getUser_id().equals(userId)) {
			try {
				delete=questionMapper.deleteQnaOne(qnaboardNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/question/qnaList/1";
		} else {
			return "redirect:/user/login.do";
		}
	}
	
	
	@GetMapping("/myQna/{userId}")
	public String myQna(@PathVariable String userId, QnaBoard qnaboard, @SessionAttribute User loginUser, Model model) {	
		List<QnaBoard> qnaboards=questionMapper.selectByUserId(userId);
		if(loginUser!=null && loginUser.getUser_id().equals(userId)) {
			model.addAttribute("qnaboards",qnaboards);		
			model.addAttribute("userId",userId);
			return "/question/myQna";
		}else {
			return "redirect:/user/login.do";
		}
	}
	
	@GetMapping("/center")
	public String center() {
		return "/question/center";
	}
	
	
}