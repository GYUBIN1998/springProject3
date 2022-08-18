package com.group3.springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group3.springProject.dto.Product;
import com.group3.springProject.mapper.ProductMapper;


@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductMapper productMapper;
	
	@GetMapping("/productDetailPage/{prodId}")
	public String productDetail(@PathVariable String prodId, Model model) {
		System.out.println(prodId);
		Product product=productMapper.selectFindOne(prodId);
		model.addAttribute(product);
		return "/product/productDetailPage";
	}
	
}
