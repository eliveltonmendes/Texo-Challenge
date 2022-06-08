package com.example.texo.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.texo.database.entity.Studio;

public interface StudioRepository extends JpaRepository<Studio, Long> {    
    public Studio findByName(String name);
}
