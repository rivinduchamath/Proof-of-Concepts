package com.cloudofgoods.catalog;

import com.cloudofgoods.catalog.business.CategoryService;
import com.cloudofgoods.catalog.dto.CategoryDTO;
import com.cloudofgoods.catalog.entity.Category;
import com.cloudofgoods.catalog.repository.CategoryDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
@EnableCaching
@RequiredArgsConstructor
@Slf4j
public class ApplicationCatalog implements CommandLineRunner {
    private final CategoryDetailRepository categoryDetailRepository;
    private final CategoryService categoryService;
    public static void main(String[] args) {
        SpringApplication.run(ApplicationCatalog.class, args);
    }
    @Override
    public void run(String... args) {
        Category categoryDTO = new Category();
        categoryDTO.setId(1L);
        categoryDTO.setCategoryName("root");
        categoryDTO.setActive(true);
        categoryDTO.setAuthUserId(1L);
        categoryDTO.setSkuIdentifier("rootCategorySKU");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date date = new Date();

        categoryDTO.setCreatedAt(null);
        categoryDTO.setUpdatedAt(null);
        categoryDTO.setParent(null);
        categoryDTO.setHeight(0);
        categoryDTO.setRoot_id(1);
//        CategoryDTO saveCategoryDTO = categoryService.saveCategory(categoryDTO);
        Category saveCategory = categoryDetailRepository.save(categoryDTO);
        log.info("LOG:: Root Category Added When Server Start "+saveCategory.getCategoryName());
    }
}
