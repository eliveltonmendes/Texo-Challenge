package com.example.texo.dto;

public class MoviesDTO {
    private String movie;
    private Integer year;

    public MoviesDTO(String movie, Integer year) {
        this.movie = movie;
        this.year = year;
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
}