package com.cloudofgoods.catalog.business;

import com.cloudofgoods.catalog.dto.ItemDTO;
import com.cloudofgoods.catalog.entity.Item;

public interface ItemService {
    ItemDTO saveItem(ItemDTO item);
}
