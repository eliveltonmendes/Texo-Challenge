package com.example.texo.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.texo.database.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Movie findByTitle(String title);
    public List<Movie> findByWinner(Boolean winner);
}
