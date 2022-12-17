package com.cloudofgoods.catalog.business;

import com.cloudofgoods.catalog.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO saveCategory(CategoryDTO category);


    List<CategoryDTO> getAllCategory(String category);


    CategoryDTO replaceParent(long nodeId, long parentId);

    List<CategoryDTO> getAllCategoryUnderParent(Long categoryId, String category);
}
