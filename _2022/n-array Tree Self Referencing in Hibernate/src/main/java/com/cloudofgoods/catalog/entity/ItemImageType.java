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
@Table(name = "item_image_type")
public class ItemImageType {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "description" , columnDefinition = "text")
    private String description;
    @Column(name = "auth_user_id")
    private Long authUser;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "itemImageType")
    private List<ItemImage> itemImageTypes = new ArrayList<>();

}
