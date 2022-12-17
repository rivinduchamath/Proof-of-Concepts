package com.cloudofgoods.catalog.business.impl;

import com.cloudofgoods.catalog.business.ItemService;
import com.cloudofgoods.catalog.dto.ItemDTO;
import com.cloudofgoods.catalog.entity.Item;
import com.cloudofgoods.catalog.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        log.info("LOG:: ItemServiceImpl saveItem " + itemDTO.getItemName());
        Item item = modelMapper.map(itemDTO, Item.class);
        Item saveItem = itemRepository.save(item);
        return modelMapper.map(saveItem, ItemDTO.class);
    }
}
