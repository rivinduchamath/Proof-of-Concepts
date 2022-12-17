package com.cloudofgoods.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actual_catalog_item_cluster_pricing_level")
public class ActualCatalogItemClusterPricingLevel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "actual_catalog_Item_cluster_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ActualCatalogItemCluster actualCatalogItemCluster;
    @Column(name = "pricing_level")
    private Long pricingLevel;
    @Column(name = "is_active")
    private boolean active;
    @Column(name = "auth_user_id")
    private Long authUserId;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

}
