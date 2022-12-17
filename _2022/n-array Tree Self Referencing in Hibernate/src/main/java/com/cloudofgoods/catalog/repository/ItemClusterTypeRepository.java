package com.cloudofgoods.catalog.repository;

import com.cloudofgoods.catalog.entity.ItemClusterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemClusterTypeRepository extends JpaRepository<ItemClusterType, Long> {
}
