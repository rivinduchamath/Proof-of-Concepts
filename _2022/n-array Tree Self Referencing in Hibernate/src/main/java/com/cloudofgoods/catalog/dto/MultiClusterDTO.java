package com.cloudofgoods.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiClusterDTO {

    private Long id;
    private MultiClusterMapperDTO multiClusterNameDTO;
    private String description;
    private Long authUserId;
    private Date createdAt;
    private Date updatedAt;
}
