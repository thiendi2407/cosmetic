package com.cosmetic_app.data.repository;

import com.cosmetic_app.data.models.IngredientInfo;
import com.cosmetic_app.data.models.Manufacture;
import com.cosmetic_app.data.models.ManufactureInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Integer> {
    public Manufacture findByName(String name);

    @Query("SELECT new com.cosmetic_app.data.models.ManufactureInfo(igd.name, mf.name, mf.address, mf.phoneNumber, da.quantity, da.metricType) " +
            "FROM DataArchive da, " +
            "Ingredient igd, " +
            "Manufacture mf " +
            "WHERE mf.name = :name " +
            "AND da.ingredientId = igd.id " +
            "AND da.manufactureId = mf.id")
    public List<ManufactureInfo> findAvailability(String name);
}
