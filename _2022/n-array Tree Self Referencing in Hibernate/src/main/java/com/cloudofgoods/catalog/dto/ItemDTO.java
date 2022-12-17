package com.cloudofgoods.catalog.dto;

import com.cloudofgoods.catalog.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    @Id
    private Long id;
    private String itemName;
    private String description;
    private String skuIdentifier;
    private Long authUser;
    private Brand brand;
    private List<ItemCategoryDTO> itemCategories = new ArrayList<>();
    private Date createdAt;
    private Date updatedAt;
    private List<ActualCatalogItemClusterDTO> actualCatalogItemClusters = new ArrayList<>();
    private List<ItemAndItemClusterDataDTO> itemAndItemClusterData = new ArrayList<>();

}
