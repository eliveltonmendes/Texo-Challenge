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
@Entity(name = "producer")
public class Producer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "producer_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
    private String name;

	@OneToMany(mappedBy = "producer")
	private List<MovieProducer> movieProducers;

	public Producer() {
		super();
	}

	public Producer(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieProducer> getMovieProducers() {
		return movieProducers;
	}

	public void setMovieProducers(List<MovieProducer> movieProducers) {
		this.movieProducers = movieProducers;
	}
}
