package com.group3.springProject.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.group3.springProject.dto.FaqBoard;
import com.group3.springProject.dto.QnaBoard;
@Mapper
public interface QuestionMapper {
	public List<QnaBoard> selectQnaAll(int startRow, int row);
	public int selectQnaAllCount();
	public List<FaqBoard> selectFaqAll(int startRow, int row);
	public int selectFaqAllCount();
}