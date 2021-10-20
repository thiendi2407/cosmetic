package com.cosmetic_app.data.repository;

import com.cosmetic_app.data.models.DataArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataArchiveRepository extends JpaRepository<DataArchive, Integer> {


}
