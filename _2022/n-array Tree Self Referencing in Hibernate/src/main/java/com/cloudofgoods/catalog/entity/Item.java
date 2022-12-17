package com.cloudofgoods.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "item")
public class Item implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "item_name")
    private String itemName;
    @Column(length = 1000)
    private String description;
    @Column(name = "sku_identifier")
    private String skuIdentifier;
    @Column(name = "oauth_user_id")
    private Long authUser;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "brand_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Brand brand;
    @OneToMany(mappedBy = "item")
    private List<ItemCategory> itemCategories = new ArrayList<>();
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @OneToMany(mappedBy = "item")
    private List<ActualCatalogItemCluster> actualCatalogItemClusters = new ArrayList<>();

    @OneToMany(mappedBy = "itemId")
    private List<ItemAndItemClusterData> itemAndItemClusterData = new ArrayList<>();

    @OneToMany(mappedBy = "itemImageType")
    private List<ItemImage> itemImageTypes = new ArrayList<>();

}
