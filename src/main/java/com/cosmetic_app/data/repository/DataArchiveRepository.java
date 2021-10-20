package com.lekwacious.employee_app.data.repository;

import com.lekwacious.employee_app.data.models.DataArchive;
import com.lekwacious.employee_app.data.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataArchiveRepository extends JpaRepository<DataArchive, Integer> {
}
