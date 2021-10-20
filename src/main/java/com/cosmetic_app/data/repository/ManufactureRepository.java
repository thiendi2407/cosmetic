package com.lekwacious.employee_app.data.repository;

import com.lekwacious.employee_app.data.models.Ingredient;
import com.lekwacious.employee_app.data.models.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Integer> {
    public Manufacture findByName(String name);
}
