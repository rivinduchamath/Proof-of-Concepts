package com.cloudofgoods.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class MultiClusterMapper implements Serializable {
    @EmbeddedId
    private MultiClusterMapperPK multiClusterMapperPK;

    @MapsId("itemAndItemClusterDataPK")
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "itemId", referencedColumnName = "itemId"), @JoinColumn(name = "itemClusterDataId", referencedColumnName = "itemClusterDataId")})
    private ItemAndItemClusterData itemAndItemClusterData;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "actualCatalogItemClusterId", referencedColumnName = "id", insertable = false, updatable = false)
    private ActualCatalogItemCluster actualCatalogItemClusterId;
    @Column(name = "auth_user_id")
    private Long authUserId;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

}
