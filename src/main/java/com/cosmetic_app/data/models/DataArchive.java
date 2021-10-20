package com.lekwacious.employee_app.data.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DataArchive {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="manufacture_id", insertable = false, updatable = false)
    private Manufacture manufacture;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ingredient_id", insertable = false, updatable = false)
    private Ingredient ingredient;

    private String metricType;

    public DataArchive() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataArchive that = (DataArchive) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(manufacture, that.manufacture) &&
                Objects.equals(ingredient, that.ingredient) &&
                Objects.equals(metricType, that.metricType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, manufacture, ingredient, metricType);
    }
}
