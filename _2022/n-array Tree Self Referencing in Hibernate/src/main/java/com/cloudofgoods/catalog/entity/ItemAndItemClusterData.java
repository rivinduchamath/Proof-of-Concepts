package com.cloudofgoods.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_item_cluster_data")
public class ItemAndItemClusterData implements Serializable {
    @EmbeddedId
    private ItemAndItemClusterDataPK itemAndItemClusterDataPK;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "auth_user_id")
    private Long authUserId;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "itemClusterDataId", referencedColumnName = "id", insertable = false, updatable = false)
    private ItemClusterData itemClusterDataId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "itemId", referencedColumnName = "id", insertable = false, updatable = false)
    private Item itemId;
    @OneToMany(mappedBy = "itemAndItemClusterData")
    private List<MultiClusterMapper> multiClusterMappers = new ArrayList<>();
}
