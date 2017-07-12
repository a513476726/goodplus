package com.zzg.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzg.category.pojo.CategoryPojo;
import com.zzg.category.serviceImpl.CategoryServiceImpl;

@Controller
public class CategoryController {
	@Autowired
	private  CategoryServiceImpl  categoryServiceImpl;
	
	@RequestMapping(value="/getcategory")
	public String   getcategory(Model model){
		List<CategoryPojo> list = categoryServiceImpl.getCategorys();
		model.addAttribute("categorys", list);
		return  "/jsps/left";
	}
	
}