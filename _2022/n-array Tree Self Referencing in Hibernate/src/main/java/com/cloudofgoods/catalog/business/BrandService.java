package com.cloudofgoods.catalog.business;

import com.cloudofgoods.catalog.dto.BrandDTO;
import com.cloudofgoods.catalog.entity.Brand;

public interface BrandService {
    BrandDTO saveBrand(BrandDTO brand);
}
