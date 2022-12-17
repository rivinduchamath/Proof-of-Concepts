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
@Table(name = "item_image")
public class ItemImage implements Serializable {
    @EmbeddedId
    private ItemImagePK itemImagePK;
    @Column(name = "image_url" , length = 2000)
    private String imageUrl;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "auth_user_id")
    private Long authUser;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Item item;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "item_image_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ItemImageType itemImageType;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

}
