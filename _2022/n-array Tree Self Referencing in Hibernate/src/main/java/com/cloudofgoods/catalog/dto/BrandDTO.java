package com.cloudofgoods.catalog.dto;

import com.cloudofgoods.catalog.entity.BrandCategory;
import com.cloudofgoods.catalog.entity.BusinessBrand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandDTO {
    private Long id;

    private String brandName;
    private boolean accept;
    private String description;
    private String skuIdentifier;
    private Long authUser;
    private Date createdAt;
    private Date updatedAt;
    private List<BusinessBrandDTO> businessBrands = new ArrayList<>();
    private List<BrandCategoryDTO> brandCategories = new ArrayList<>();
}
