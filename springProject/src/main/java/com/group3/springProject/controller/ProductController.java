package com.group3.springProject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group3.springProject.dto.Paging;
import com.group3.springProject.dto.Product;
import com.group3.springProject.mapper.ProductMapper;
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductMapper productMapper;
	
	@GetMapping("/productList/{page}")
	public String productList(
			@PathVariable int page, 
			@RequestParam(required = false) String search,
			@RequestParam(required = false) String sort,
			@RequestParam(required = false, defaultValue = "desc") String direct,
			Model model) {
		int row = 5;
		int startRow = (page - 1) * row;
		
		int rowCount = 0;
		List<Product> products = null;
		
		if((search != null && !search.equals(""))) { // 검색
			if((sort != null && !sort.equals(""))) { // 검색 + 정렬
				products = productMapper.selectAll(startRow, row, search, sort, direct);
				rowCount = productMapper.selectAllCount(search, sort, direct);	
			} else { // 검색 + 정렬(x)
				products = productMapper.selectAll(startRow, row, search, null, null);
				rowCount = productMapper.selectAllCount(search, null, null);	
			}
			System.out.println(products);
		} else { // 검색(x)
			if((sort != null && !sort.equals(""))) { // 검색(x) + 정렬
				products = productMapper.selectAll(startRow, row, null, sort, direct);
				rowCount = productMapper.selectAllCount(null, sort, direct);	
			} else { // 검색(x) + 정렬(x)
				products = productMapper.selectAll(startRow, row, null, null, null);
				rowCount = productMapper.selectAllCount(null, null, null);	
			}
			System.out.println(products);
		}
		
		Paging pageProductAll = new Paging(page, rowCount, "/product/productList/", row);
		
		model.addAttribute("products", products);
		model.addAttribute("row", row);
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("page", page);
		model.addAttribute("pageProductAll", pageProductAll);
		
		return "/product/productList";	
	}
	
	@GetMapping("/productDetail/{prodId}")
	public String productDetail(@PathVariable String prodId, Model model) {
		System.out.println(prodId);
		Product product=productMapper.selectFindOne(prodId);
		model.addAttribute(product);
		return "/product/productDetail";
	}	
}