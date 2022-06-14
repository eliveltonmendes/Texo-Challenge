package com.example.texo.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.texo.database.entity.Producer;
import com.example.texo.dto.WinnerProducersDTO;
import com.example.texo.dto.newDto.ProducersDTO;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
    public Producer findByName(String name);

    //Capturar os produtores vencedores + filme, ano do filme em um dto
    //Montar um dto com os períodos agrupados por produtor

    // @Query(value = "select new com.example.texo.dto.newDto.ProducersDTO(p.name, new m.title, m.year) " +
    @Query(value = "select new com.example.texo.dto.newDto.ProducersDTO(p.name, m.title, m.year) " +
        " from producer p" +
        " join p.movieProducers mp" +
        " join mp.movie m" +
        " where m.winner = true" +
        " order by p.name, m.year asc")
    public List<ProducersDTO> findMovieWinners();

    @Query(value = "select new com.example.texo.dto.WinnerProducersDTO(p.name, min(m.year) as minimo, max(m.year) as maximo, (max(m.year) - min(m.year)))" +
        " from producer p" +
        " join p.movieProducers mp" +
        " join mp.movie m" +
        " where m.winner = true" +
        " group by p.name" +
        " order by p.name")
    public List<WinnerProducersDTO> findProducerWithWinnerMovies();
}
