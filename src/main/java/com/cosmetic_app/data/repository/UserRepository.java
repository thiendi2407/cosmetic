package com.cosmetic_app.data.repository;

import com.cosmetic_app.data.models.Ingredient;
import com.cosmetic_app.data.models.IngredientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    public Ingredient findByName(String name);

    @Query("SELECT new com.cosmetic_app.data.models.IngredientInfo(igd.name, mf.name, mf.address, mf.phoneNumber, da.quantity, da.metricType) " +
            "FROM DataArchive da, " +
            "Ingredient igd, " +
            "Manufacture mf " +
            "WHERE igd.name = :name " +
            "AND da.ingredientId = igd.id " +
            "AND da.manufactureId = mf.id")
    public List<IngredientInfo> findAvailability(String name);
}
