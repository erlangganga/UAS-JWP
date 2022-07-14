package com.example.libr.entities;

import javax.persistence.*;

@SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
@Entity
@Table (name = "category")
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    @Column(nullable = false)
    public String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}