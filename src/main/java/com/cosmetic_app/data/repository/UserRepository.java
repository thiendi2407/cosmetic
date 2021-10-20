package com.cosmetic_app.data.repository;

import com.cosmetic_app.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.userName = :name " +
            "AND u.password = :password")
    public User findUser(String name, String password);
}
