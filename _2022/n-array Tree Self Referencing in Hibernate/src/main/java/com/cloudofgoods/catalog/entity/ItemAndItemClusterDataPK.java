package com.cloudofgoods.catalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemAndItemClusterDataPK implements Serializable {
    @Column(name = "itemId")
    private Long itemId;
    @Column(name = "itemClusterDataId")
    private Long itemClusterDataId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemAndItemClusterDataPK)) return false;
        ItemAndItemClusterDataPK that = (ItemAndItemClusterDataPK) o;
        return Objects.equals(getItemId(), that.getItemId()) && Objects.equals(getItemClusterDataId(), that.getItemClusterDataId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getItemClusterDataId());
    }
}
