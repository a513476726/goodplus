package com.zzg.category.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzg.category.dao.CategoryMapperImpl;
import com.zzg.category.pojo.CategoryPojo;
import com.zzg.category.service.ICategoryService;


@Service
public class CategoryServiceImpl  implements ICategoryService{
	@Autowired
	private  CategoryMapperImpl  categoryServiceImpl;
	@Override
	public List<CategoryPojo> getCategorys() {
		
		return categoryServiceImpl.selectAllCategorys();
	}
	
}
