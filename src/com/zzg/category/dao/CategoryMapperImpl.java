package com.zzg.category.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzg.category.pojo.CategoryPojo;
import com.zzg.dao.CategoryMapper;
import com.zzg.domain.Category;
import com.zzg.domain.CategoryExample;

@Repository
public class CategoryMapperImpl implements  CategoryMapper {
	@Autowired
	private  CategoryMapper  categoryMapper;

	public List<CategoryPojo> selectAllCategorys() {
				List<CategoryPojo>   categoryPojos = new ArrayList<CategoryPojo>();
				//1  select  *  from   category   where  pid  is  null
				CategoryExample  example  = new CategoryExample();
				example.createCriteria().andPidIsNull();
				List<Category> list= this.categoryMapper.selectByExample(example);
				System.out.println("-----------------------------"+list);
				//2  
				for (Category category : list) {
					CategoryPojo  pojo  = new CategoryPojo();
					//  pojo     target  
					//   category       src  
					BeanUtils.copyProperties(category, pojo);
					System.out.println(pojo+"???????????????????????????????????????????????????????????????");
					CategoryExample  example2  = new CategoryExample();
					System.out.println("-------------------"+category.getCid());
					example2.createCriteria().andPidEqualTo(category.getCid());
					List<Category> children= this.categoryMapper.selectByExample(example2);
					pojo.setChildren(children);
					
					categoryPojos.add(pojo);
				}
				System.out.println("----------123-------------"+categoryPojos);
				
				return categoryPojos;
	}

	@Override
	public int countByExample(CategoryExample example) {
		// TODO Auto-generated method stub
		return  categoryMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CategoryExample example) {
		// TODO Auto-generated method stub
		return this.categoryMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String cid) {
		// TODO Auto-generated method stub
		return this.categoryMapper.deleteByPrimaryKey(cid);
	}

	@Override
	public int insert(Category record) {
		// TODO Auto-generated method stub
		return this.categoryMapper.insert(record);
	}

	@Override
	public int insertSelective(Category record) {
		// TODO Auto-generated method stub
		return this.categoryMapper.insertSelective(record);
	}

	@Override
	public List<Category> selectByExample(CategoryExample example) {
		// TODO Auto-generated method stub
		return this.selectByExample(example);
	}

	@Override
	public Category selectByPrimaryKey(String cid) {
		// TODO Auto-generated method stub
		return this.categoryMapper.selectByPrimaryKey(cid);
	}

	@Override
	public int updateByExampleSelective(Category record, CategoryExample example) {
		// TODO Auto-generated method stub
		return this.categoryMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Category record, CategoryExample example) {
		// TODO Auto-generated method stub
		return this.categoryMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Category record) {
		// TODO Auto-generated method stub
		return this.categoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Category record) {
		// TODO Auto-generated method stub
		return   this.categoryMapper.updateByPrimaryKey(record);
	}
}
