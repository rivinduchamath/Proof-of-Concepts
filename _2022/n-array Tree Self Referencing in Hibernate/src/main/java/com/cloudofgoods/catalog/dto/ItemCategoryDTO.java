package com.cloudofgoods.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCategoryDTO {
    private Long itemId;
    private Long categoryId;
    private Date createdAt;
    private Date updatedAt;

}
