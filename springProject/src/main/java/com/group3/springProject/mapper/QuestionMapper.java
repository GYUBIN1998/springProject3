package com.group3.springProject.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.group3.springProject.dto.FaqBoard;
import com.group3.springProject.dto.QnaBoard;
@Mapper
public interface QuestionMapper {
	public List<QnaBoard> selectQnaAll(int startRow, int row, @Param(value = "field")String field, @Param(value = "search")String search);
	public List<QnaBoard> selectQnaAll(int startRow, int row);
	public int selectQnaAllCount(String field, String search);
	public int selectQnaAllCount();
	
	public List<FaqBoard> selectFaqAll(int startRow, int row, @Param(value = "field")String field, @Param(value = "search")String search);
	public List<FaqBoard> selectFaqAll(int startRow, int row);
	public int selectFaqAllCount(String field, String search);
	public int selectFaqAllCount();
	
	public List<FaqBoard> selectFaqCategory(int faq_division_no, int startRow, int row, @Param(value = "field")String field, @Param(value = "search")String search);
	public List<FaqBoard> selectFaqCategory(int faq_division_no, int startRow, int row);
	public int selectFaqCategoryCount(int faq_division_no, String field, String search);
	public int selectFaqCategoryCount(int faq_division_no);
	
	public QnaBoard selectQnaFindOne(int qnaboardNo);
	public int insertQnaOne(QnaBoard qnaBoard);
	public int updateQnaOne(QnaBoard qnaBoard);
	public int deleteQnaOne(int qnaBoardNo);
}