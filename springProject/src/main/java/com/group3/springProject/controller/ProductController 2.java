package com.group3.springProject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group3.springProject.dto.Paging;
import com.group3.springProject.dto.Product;
import com.group3.springProject.mapper.ProductMapper;
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductMapper productMapper;
	
	@GetMapping("/productList/{page}")
	public String productList(@PathVariable int page, Model model) {
		int row = 5;
		int startRow = (page - 1) * row;
		int rowCount = productMapper.selectAllCount();
		Paging paging = new Paging(page, rowCount, "/product/productList/", row);
		List<Product> products = productMapper.selectAll(startRow, row);
		model.addAttribute("products", products);
		model.addAttribute("paging", paging);
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("page", page);
		model.addAttribute("row", row);
		System.out.println(products);
		return "/product/productList";	
	}
	
	@GetMapping("/productDetailPage/{prodId}")
	public String productDetail(@PathVariable String prodId, Model model) {
		System.out.println(prodId);
		Product product=productMapper.selectFindOne(prodId);
		model.addAttribute(product);
		return "/product/productDetailPage";
	}	
}
