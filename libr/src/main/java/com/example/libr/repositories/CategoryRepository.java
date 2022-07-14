package com.example.libr.repositories;

import com.example.libr.entities.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<category, Integer> {
    static void Save(category ignoredCategory) {
    }

    List<category> findAll();
}