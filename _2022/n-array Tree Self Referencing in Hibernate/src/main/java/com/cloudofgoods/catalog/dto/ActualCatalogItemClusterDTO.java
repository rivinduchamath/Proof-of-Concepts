package com.cloudofgoods.catalog.dto;

import com.cloudofgoods.catalog.entity.Item;
import com.cloudofgoods.catalog.entity.StockStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ActualCatalogItemClusterDTO {
    private Long id;
    private String actualCatalogClusterName;
    private Item item;
    private StockStatus stockStatus;
    private String description;
    private String skuIdentifier;
    private String authUserId;
    private Date createdAt;
    private Date updatedAt;
    private List<MultiClusterMapperDTO> multiClusterMappers = new ArrayList<>();
    private List<ActualCatalogItemClusterPricingLevelDTO> actualCatalogItemClusterPricingLevels = new ArrayList<>();
}
