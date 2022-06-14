package com.example.texo.dto.newDto;

import java.util.List;

public class ProducersDTO {

    private String producer;
    private String movie;
    private Integer year;
    private List<MoviesDTO> movies;

    public ProducersDTO() {}
    public ProducersDTO(String producer, String movie, Integer year) {
        this.producer = producer;
        this.movie = movie;
        this.year = year;
    }

    public ProducersDTO(String producer, List<MoviesDTO> movies) {
        this.producer = producer;
        this.movies = movies;
    }
    
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public String getMovie() {
        return movie;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    public List<MoviesDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MoviesDTO> movies) {
        this.movies = movies;
    }
}
