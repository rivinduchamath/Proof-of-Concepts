package com.cloudofgoods.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandCategoryDTO {
    private Long brandId;
    private Long categoryId;
    private Long authUserId;
    private Date createdAt;
    private Date updatedAt;
}
