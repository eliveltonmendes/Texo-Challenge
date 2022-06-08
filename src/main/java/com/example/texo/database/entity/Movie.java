package com.example.texo.database.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "event_year", length = 4, nullable = false)
	private Integer year;

	@Column(name = "title", length = 255, nullable = false)
	private String title;

	@Column(name = "winner")
	private Boolean winner;	

	@OneToMany(mappedBy = "movie")
	private List<MovieProducer> movieProducers;

	public Movie() {
		super();
	}
	
	public Movie(String title, Integer year, Boolean winner) {
		super();
		this.year = year;
		this.title = title;
		this.winner = winner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getWinner() {
		return winner;
	}

	public void setWinner(Boolean winner) {
		this.winner = winner;
	}

	public List<MovieProducer> getMovieProducers() {
		return movieProducers;
	}
}
