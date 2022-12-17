package com.cloudofgoods.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualCatalogItemClusterPricingLevelDTO {
    private Long id;
    private ActualCatalogItemClusterDTO actualCatalogItemCluster;
    private Long pricingLevel;
    private boolean active;
    private Long authUserId;
    private Date createdAt;
    private Date updatedAt;
}
