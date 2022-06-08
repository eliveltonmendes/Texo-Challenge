package com.example.texo.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.texo.database.entity.Producer;
import com.example.texo.dto.WinnerProducersDTO;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
    public Producer findByName(String name);

    @Query(value = "select new com.example.texo.dto.WinnerProducersDTO(p.name, min(m.year) as minimo, max(m.year) as maximo, (max(m.year) - min(m.year)))" +
        " from producer p" +
        " join p.movieProducers mp" +
        " join mp.movie m" +
        " where m.winner = true" +
        " group by p.name"
        )
    public List<WinnerProducersDTO> findProducerwinner();
}
