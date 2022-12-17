package com.cloudofgoods.catalog.dto;

import com.cloudofgoods.catalog.entity.BrandCategory;
import com.cloudofgoods.catalog.entity.Category;
import com.cloudofgoods.catalog.entity.ItemCategory;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Comparable<CategoryDTO>, Serializable {
    private Long id;
    private String categoryName;
    private boolean active;
    private Long authUserId;
    private String skuIdentifier;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
    private Date createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
    private Date updatedAt;
    private Category parent;

    private long height;

    private long root_id;
    private List<Category> children;

    private List<BrandCategory> brandCategories;
    private List<ItemCategory> itemCategories;

    public CategoryDTO(String categoryName, boolean active, Long authUserId, String skuIdentifier, Date createdAt, Date updatedAt, long height, long root_id, List<BrandCategory> brandCategories, List<ItemCategory> itemCategories) {
        this.categoryName = categoryName;
        this.active = active;
        this.authUserId = authUserId;
        this.skuIdentifier = skuIdentifier;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.height = height;
        this.root_id = root_id;
        this.brandCategories = brandCategories;
        this.itemCategories = itemCategories;
    }

    public CategoryDTO(String categoryName, boolean active, Long authUserId, String skuIdentifier, Date createdAt, Date updatedAt, List<BrandCategory> brandCategories, List<ItemCategory> itemCategories) {
        this.categoryName = categoryName;
        this.active = active;
        this.authUserId = authUserId;
        this.skuIdentifier = skuIdentifier;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.brandCategories = brandCategories;
        this.itemCategories = itemCategories;
    }

    @Override
    public int compareTo(CategoryDTO o) {
        return Objects.equals(getId(), o.getId()) ? 0 : (getId() > o.getId() ? 1 : -1);
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", categoryName:'" + categoryName + '\'' +
                ", active:" + active +
                ", authUserId:" + authUserId +
                ", skuIdentifier:'" + skuIdentifier + '\'' +
                ", createdAt:" + createdAt +
                ", updatedAt:" + updatedAt +
                ", height:" + height +
                ", root_id:" + root_id +
                ", children:" + children +
                ", brandCategories:" + brandCategories +
                ", itemCategories:" + itemCategories +
                '}';
    }

}
