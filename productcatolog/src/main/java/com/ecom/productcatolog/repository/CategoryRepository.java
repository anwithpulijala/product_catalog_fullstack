package com.ecom.productcatolog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.productcatolog.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
