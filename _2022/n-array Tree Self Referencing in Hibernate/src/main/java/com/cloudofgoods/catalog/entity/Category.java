package com.cloudofgoods.catalog.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(indexes = {@Index(name = "IDX_height", columnList = "id")})
@NoArgsConstructor
@NamedQuery(name = "Category.getAllCategory", query = "SELECT distinct n FROM Category n left join fetch n.children ")
public @Data class Category implements Comparable<Category>, SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "category_sequence")
    @Column(name = "id", nullable = false)
//    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(name = "category_name")
    private String categoryName;
    private boolean active;
    @Column(name = "oauth_user_id")
    private Long authUserId;
    @Column(name = "sku_identifier")
    private String skuIdentifier;
    @Column(name = "created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss", timezone = "UTC")
    private Date createdAt;
    @Column(name = "updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss", timezone = "UTC")
    private Date updatedAt;
    private long height;
    private long root_id;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Category parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private List<Category> children;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<BrandCategory> brandCategories;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<ItemCategory> itemCategories;

    @Override
    public int compareTo(Category o) {
        return Objects.equals(getId(), o.getId()) ? 0 : (getId() > o.getId() ? 1 : -1);
    }


    @Override
    public String toString() {
        return "{" + "id:" + id + ", categoryName:'" + categoryName + '\'' + ", active:" + active + ", authUserId:" + authUserId + ", skuIdentifier:'" + skuIdentifier + '\'' + ", createdAt:" + createdAt + ", updatedAt:" + updatedAt + ", height:" + height + ", root_id:" + root_id + ", children:" + children +  '}';
    }
}

