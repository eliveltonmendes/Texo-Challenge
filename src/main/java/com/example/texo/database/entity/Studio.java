package com.example.texo.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Studio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studio_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name", length = 255, nullable = false)
	private String name;

	public Studio() {
	}

	public Studio(String name) {
		super();
		this.name = name;
	}
}
