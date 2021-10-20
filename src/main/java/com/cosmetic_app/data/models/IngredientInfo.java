package com.cosmetic_app.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class IngredientInfo {

    private String ingredient_name;

    private String manufacture_name;

    private String manufacture_address;

    private String manufacture_phoneNumber;

    private String quantity;

    private String metric_type;

    public IngredientInfo(String ingredient_name, String manufacture_name, String manufacture_address, String manufacture_phoneNumber, String quantity, String metric_type) {
        this.ingredient_name = ingredient_name;
        this.manufacture_name = manufacture_name;
        this.manufacture_address = manufacture_address;
        this.manufacture_phoneNumber = manufacture_phoneNumber;
        this.quantity = quantity;
        this.metric_type = metric_type;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public String getManufacture_name() {
        return manufacture_name;
    }

    public void setManufacture_name(String manufacture_name) {
        this.manufacture_name = manufacture_name;
    }

    public String getManufacture_address() {
        return manufacture_address;
    }

    public void setManufacture_address(String manufacture_address) {
        this.manufacture_address = manufacture_address;
    }

    public String getManufacture_phoneNumber() {
        return manufacture_phoneNumber;
    }

    public void setManufacture_phoneNumber(String manufacture_phoneNumber) {
        this.manufacture_phoneNumber = manufacture_phoneNumber;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMetric_type() {
        return metric_type;
    }

    public void setMetric_type(String metric_type) {
        this.metric_type = metric_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientInfo that = (IngredientInfo) o;
        return Objects.equals(ingredient_name, that.ingredient_name) &&
                Objects.equals(manufacture_name, that.manufacture_name) &&
                Objects.equals(manufacture_address, that.manufacture_address) &&
                Objects.equals(manufacture_phoneNumber, that.manufacture_phoneNumber) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(metric_type, that.metric_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient_name, manufacture_name, manufacture_address, manufacture_phoneNumber, quantity, metric_type);
    }
}
