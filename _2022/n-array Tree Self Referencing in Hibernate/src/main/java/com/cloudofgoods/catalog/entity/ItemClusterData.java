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
@Table(name = "item_cluster_data")
public class ItemClusterData {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "cluster_data")
    private String clusterData;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "sku_identifier")
    private String skuIdentifier;
    @Column(name = "auth_user_id")
    private Long authUserId;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @OneToMany(mappedBy = "itemClusterDataId")
    private List<ItemAndItemClusterData> itemAndItemClusterData = new ArrayList<>();
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "item_cluster_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ItemClusterType itemClusterType;


}
