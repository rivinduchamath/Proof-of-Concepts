package com.cloudofgoods.catalog.business.impl;

import com.cloudofgoods.catalog.business.CategoryService;
import com.cloudofgoods.catalog.dto.CategoryDTO;
import com.cloudofgoods.catalog.entity.Category;
import com.cloudofgoods.catalog.repository.CategoryDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDetailRepository categoryDetailRepository;
    private final ModelMapper modelMapper;

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        log.info("LOG :: CategoryServiceImpl saveCategory() " + categoryDTO.getId());
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category saveCategory = categoryDetailRepository.save(category);
        return modelMapper.map(saveCategory, CategoryDTO.class);
    }

    @Override
    @Cacheable(key = "#category", value = "category")
    public List<CategoryDTO> getAllCategory(String category) {
        List<Category> allCategory = categoryDetailRepository.getAllCategory();
        return allCategory.stream().map(this::convertorWithoutRelationShips).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO replaceParent(long nodeId, long parentId) {
        AtomicReference<Category> atomicReference = new AtomicReference<>(new Category());
        Optional<Category> parNode = categoryDetailRepository.findById(parentId);
        Optional<Category> currNode = categoryDetailRepository.findById(nodeId);
        currNode.ifPresent(category -> {
            parNode.ifPresent(category::setParent);
            atomicReference.set(categoryDetailRepository.save(currNode.get()));
        });
        return convertor(atomicReference.get());
    }

    @Override
    public List<CategoryDTO> getAllCategoryUnderParent(Long categoryId, String category) {
        Map<Category, List<Category>> tree = new TreeMap<Category, List<Category>>();
        List<Category> result = categoryDetailRepository.getAllCategory();
        List<Category> opList = new ArrayList<Category>();
        result.stream().filter(n -> n.getParent() != null).forEachOrdered(n -> {
            if (!tree.containsKey(n.getParent())) tree.put(n.getParent(), new ArrayList<>());
            tree.get(n.getParent()).add(n);
        });
        tree.forEach((key, value) -> {
            if (Objects.equals(key.getId(), categoryId) || opList.contains(key)) {
                opList.addAll(value);
            }
        });
        return result.stream().map(this::convertorWithoutRelationShips).collect(Collectors.toList());
    }

    private CategoryDTO convertor(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setActive(category.isActive());
        categoryDTO.setAuthUserId(category.getAuthUserId());
        categoryDTO.setSkuIdentifier(category.getSkuIdentifier());
        categoryDTO.setCreatedAt(category.getCreatedAt());
        categoryDTO.setUpdatedAt(category.getUpdatedAt());
        categoryDTO.setParent(category.getParent());
        categoryDTO.setHeight(category.getHeight());
        categoryDTO.setRoot_id(category.getRoot_id());
        return categoryDTO;
    }
    private Category convertorCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setActive(categoryDTO.isActive());
        category.setAuthUserId(categoryDTO.getAuthUserId());
        category.setSkuIdentifier(categoryDTO.getSkuIdentifier());
        category.setCreatedAt(categoryDTO.getCreatedAt());
        category.setUpdatedAt(categoryDTO.getUpdatedAt());
        category.setParent(categoryDTO.getParent());
        category.setHeight(categoryDTO.getHeight());
        category.setRoot_id(categoryDTO.getRoot_id());
        return category;
    }
    private CategoryDTO convertorWithoutRelationShips(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setActive(category.isActive());
        categoryDTO.setAuthUserId(category.getAuthUserId());
        categoryDTO.setSkuIdentifier(category.getSkuIdentifier());
        categoryDTO.setCreatedAt(category.getCreatedAt());
        categoryDTO.setUpdatedAt(category.getUpdatedAt());
        categoryDTO.setParent(category.getParent());
        categoryDTO.setHeight(category.getHeight());
        categoryDTO.setRoot_id(category.getRoot_id());
        categoryDTO.setChildren(category.getChildren());
        return categoryDTO;
    }
}
