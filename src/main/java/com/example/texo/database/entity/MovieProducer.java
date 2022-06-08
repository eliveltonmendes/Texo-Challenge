package com.example.texo.database.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "movie_producer")
public class MovieProducer {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_producer_id", unique = true, nullable = false)
	private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="producer_id", nullable = false)
    private Producer producer;

    public MovieProducer() {}
    public MovieProducer(Movie movie, Producer producer) {
        this.movie = movie;
        this.producer = producer;
    }

    public Long getId() {
        return id;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public Producer getProducer() {
        return producer;
    }
    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    
}
