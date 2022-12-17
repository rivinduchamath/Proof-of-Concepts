package com.cloudofgoods.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCategoryPK implements Serializable {
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "category_id")
    private Long categoryId;
}
