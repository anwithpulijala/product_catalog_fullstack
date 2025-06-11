package com.ecom.productcatolog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.productcatolog.model.Category;
import com.ecom.productcatolog.repository.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
	
	
	
	public CategoryService(CategoryRepository categoryRepository) {
		
		this.categoryRepository = categoryRepository;
	}



	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

}
