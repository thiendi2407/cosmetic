package com.cosmetic_app.data.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DataArchive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String quantity;

    private String metricType;

    private Integer manufactureId;

    private Integer ingredientId;

    public DataArchive() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMetricType() {
        return metricType;
    }

    public void setMetricType(String metricType) {
        this.metricType = metricType;
    }

    public Integer getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(Integer manufactureId) {
        this.manufactureId = manufactureId;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataArchive that = (DataArchive) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(metricType, that.metricType) &&
                Objects.equals(manufactureId, that.manufactureId) &&
                Objects.equals(ingredientId, that.ingredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, metricType, manufactureId, ingredientId);
    }
}
