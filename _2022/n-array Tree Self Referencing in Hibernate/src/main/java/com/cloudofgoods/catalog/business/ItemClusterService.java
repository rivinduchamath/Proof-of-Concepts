package com.cloudofgoods.catalog.business;

import com.cloudofgoods.catalog.dto.ItemClusterTypeDTO;
import com.cloudofgoods.catalog.entity.ItemClusterType;

public interface ItemClusterService {
    ItemClusterTypeDTO saveItemCluster(ItemClusterTypeDTO itemClusterType);
}
