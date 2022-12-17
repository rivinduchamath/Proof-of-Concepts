package com.cloudofgoods.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockStatus {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String status;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "auth_user_id")
    private Long authUserId;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @OneToMany(mappedBy = "stockStatus")
    private List<ActualCatalogItemCluster> actualCatalogItemClusters = new ArrayList<>();
}
