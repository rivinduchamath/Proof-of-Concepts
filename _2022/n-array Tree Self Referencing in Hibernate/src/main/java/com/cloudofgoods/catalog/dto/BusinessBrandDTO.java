package com.cloudofgoods.catalog.dto;

import com.cloudofgoods.catalog.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessBrandDTO {
    private Long id;
    private Long businessId;
    private Brand brand;
    private Date createdAt;
    private Date updatedAt;
}
