package com.lekwacious.employee_app.data.repository;

import com.lekwacious.employee_app.data.models.Ingredient;
import com.lekwacious.employee_app.data.models.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    public Ingredient findByName(String name);
}
