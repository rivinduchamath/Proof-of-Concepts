package com.cloudofgoods.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "item_cluster_type")
public class ItemClusterType {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "cluster_type")
    private String clusterType;
    private String measure;
    @Column(length = 1000)
    private String description;
    @Column(name = "auth_user_id")
    private Long authUserId;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @OneToMany(mappedBy = "itemClusterType")
    private List<ItemClusterData> itemClusterData = new ArrayList<>();
}
