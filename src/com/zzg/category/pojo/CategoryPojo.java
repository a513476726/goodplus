package com.zzg.category.pojo;

import java.util.List;

import com.zzg.domain.Category;

public class CategoryPojo  extends  Category{

	
	private   List<Category>   children ;

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "CategoryPojo [children=" + children + ", toString()="
				+ super.toString() + "]";
	}
	
}
