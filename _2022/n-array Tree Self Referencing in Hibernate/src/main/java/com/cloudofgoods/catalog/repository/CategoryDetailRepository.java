package com.cloudofgoods.catalog.repository;

import com.cloudofgoods.catalog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDetailRepository extends JpaRepository<Category, Long> {
    List<Category> getAllCategory();
//    @Query("from Category ")
//    List<Category> findAllCategory();

//    @Query()
//    Category saveCategory(Category category);
}
