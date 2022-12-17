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
@Table(name = "brand")
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "brand_name")
    private String brandName;
    private boolean accept;
    @Column(length = 1000)
    private String description;
    @Column(name = "sku_identifier")
    private String skuIdentifier;
    @Column(name = "oauth_user_id")
    private Long authUser;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @OneToMany(mappedBy = "brand")
    private List<BusinessBrand> businessBrands = new ArrayList<>();
    @OneToMany(mappedBy = "brand")
    private List<BrandCategory> brandCategories = new ArrayList<>();
}
