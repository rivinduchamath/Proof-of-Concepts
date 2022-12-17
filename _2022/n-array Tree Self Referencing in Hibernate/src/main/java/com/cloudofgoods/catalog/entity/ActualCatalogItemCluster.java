package com.cloudofgoods.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actual_catalog_item_cluster")
public class ActualCatalogItemCluster {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "actual_catalog_cluster_name")
    private String actualCatalogClusterName;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Item item;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "stock_status_id", referencedColumnName = "id", insertable = false, updatable = false)
    private StockStatus stockStatus;

    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "sku_identifier")
    private String skuIdentifier;
    @Column(name = "auth_user_id")
    private String authUserId;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @OneToMany(mappedBy = "actualCatalogItemClusterId")
    private List<MultiClusterMapper> multiClusterMappers = new ArrayList<>();
    @OneToMany(mappedBy = "actualCatalogItemCluster")
    private List<ActualCatalogItemClusterPricingLevel> actualCatalogItemClusterPricingLevels = new ArrayList<>();
}
