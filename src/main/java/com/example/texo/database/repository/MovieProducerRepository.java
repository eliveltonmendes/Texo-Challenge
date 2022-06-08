package com.example.texo.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.texo.database.entity.Movie;
import com.example.texo.database.entity.MovieProducer;

public interface MovieProducerRepository extends JpaRepository<MovieProducer, Long> {   
    public List<MovieProducer> findByMovie(Movie movie);
}
