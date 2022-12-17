package com.cloudofgoods.catalog.business.impl;

import com.cloudofgoods.catalog.business.BrandService;
import com.cloudofgoods.catalog.dto.BrandDTO;
import com.cloudofgoods.catalog.entity.Brand;
import com.cloudofgoods.catalog.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    @Override
    public BrandDTO saveBrand(BrandDTO brandDTO) {
        log.info("LOG :: BrandServiceImpl saveBrand() " + brandDTO.getBrandName());
        Brand brand = modelMapper.map(brandDTO, Brand.class);
        Brand saveBrand = brandRepository.save(brand);
        return modelMapper.map(saveBrand, BrandDTO.class);
    }
}
