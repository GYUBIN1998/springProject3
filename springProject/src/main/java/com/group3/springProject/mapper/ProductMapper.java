package com.group3.springProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.group3.springProject.dto.Product;

//com.group3.springProject.mapper.ProductMapper

@Mapper
public interface ProductMapper {
	Product selectFindOne(String prodId);
}
