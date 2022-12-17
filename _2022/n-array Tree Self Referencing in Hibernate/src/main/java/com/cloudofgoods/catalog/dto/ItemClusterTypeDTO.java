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
public class ItemClusterTypeDTO {
    private Long id;
    private String clusterType;
    private String measure;
    private String description;
    private Long authUserId;
    private Date createdAt;
    private Date updatedAt;
    private List<ItemClusterDataDTO> itemClusterDataListDTO = new ArrayList<>();
}
