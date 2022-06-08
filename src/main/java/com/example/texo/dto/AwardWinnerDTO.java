package com.example.texo.dto;

public class AwardWinnerDTO {
    private String movie;
    private String producer;
    private Integer year;
    private Integer minimo;

    public AwardWinnerDTO(String movie, String producer, Integer year) {
        this.movie = movie;
        this.producer = producer;
        this.year = year;
    }

    public AwardWinnerDTO(String movie, String producer, Integer year, Integer minimo) {
        this.movie = movie;
        this.producer = producer;
        this.year = year;
        this.minimo = minimo;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    
    
}
