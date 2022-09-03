package com.group3.springProject.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.group3.springProject.dto.Product;
//com.group3.springProject.mapper.ProductMapper
@Mapper
public interface ProductMapper {
	// 상품 검색 & 가격 검색 & 정렬
	public List<Product> selectAll(
			int startRow, 
			int row, 
			@Param(value = "search")String search, 
			@Param(value = "startMoney")String startMoney, 
			@Param(value = "endMoney")String endMoney, 
			@Param(value = "sort")String sort, 
			@Param(value = "direct")String direct);
	public int selectAllCount(
			@Param(value = "search")String search, 
			@Param(value = "startMoney")String startMoney, 
			@Param(value = "endMoney")String endMoney, 
			@Param(value = "sort")String sort, 
			@Param(value = "direct")String direct);
	
	// 그냥 상품 리스트
	public List<Product> selectAll(int startRow, int row);
	public int selectAllCount();
	
	public Product selectFindOne(String prodId);
}