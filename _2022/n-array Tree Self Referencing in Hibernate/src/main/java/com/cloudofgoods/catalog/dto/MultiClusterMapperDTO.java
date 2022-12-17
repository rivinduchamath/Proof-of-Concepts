package com.cloudofgoods.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiClusterMapperDTO {

    private Long id;
    private Long multiClusterDataId;
    private ItemAndItemClusterDataDTO itemAndItemClusterDataDTO;
    private Long authUserId;
    private Date createdAt;
    private Date updatedAt;
}
