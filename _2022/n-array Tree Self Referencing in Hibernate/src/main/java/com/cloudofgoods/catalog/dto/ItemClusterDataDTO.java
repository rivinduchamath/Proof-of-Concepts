package com.cloudofgoods.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemClusterDataDTO {
    private Long id;
    private String clusterData;
    private String description;
    private String skuIdentifier;
    private Long authUserId;
    private Date createdAt;
    private Date updatedAt;
    private List<ItemAndItemClusterDataDTO> itemAndItemClusterDataListDTO = new ArrayList<>();
    private ItemClusterTypeDTO itemClusterTypeDTO;
}
