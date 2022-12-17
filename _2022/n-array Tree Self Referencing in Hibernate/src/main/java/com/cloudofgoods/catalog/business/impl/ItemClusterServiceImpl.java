package com.cloudofgoods.catalog.business.impl;

import com.cloudofgoods.catalog.business.ItemClusterService;
import com.cloudofgoods.catalog.dto.ItemClusterTypeDTO;
import com.cloudofgoods.catalog.entity.ItemClusterType;
import com.cloudofgoods.catalog.repository.ItemClusterTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemClusterServiceImpl implements ItemClusterService {
    private final ModelMapper modelMapper;
    private final ItemClusterTypeRepository itemClusterRepository;

    @Override
    public ItemClusterTypeDTO saveItemCluster(ItemClusterTypeDTO itemClusterTypeDTO) {
        ItemClusterType itemClusterType = modelMapper.map(itemClusterTypeDTO, ItemClusterType.class);
        ItemClusterType saveItem = itemClusterRepository.save(itemClusterType);
        return modelMapper.map(saveItem, ItemClusterTypeDTO.class);
    }
}
