package com.cloudofgoods.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiClusterMapperPK implements Serializable {

    @Column(name = "itemAndItemClusterDataPK")
    private ItemAndItemClusterDataPK itemAndItemClusterDataPK;
    @Column(name = "actualCatalogItemClusterId")
    private Long actualCatalogItemClusterId;
}
