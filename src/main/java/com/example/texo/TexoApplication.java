package com.example.texo;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.ResourceUtils;

import com.example.texo.database.entity.Movie;
import com.example.texo.database.entity.MovieProducer;
import com.example.texo.database.entity.Producer;
import com.example.texo.database.entity.Studio;
import com.example.texo.database.repository.MovieProducerRepository;
import com.example.texo.database.repository.MovieRepository;
import com.example.texo.database.repository.ProducerRepository;
import com.example.texo.database.repository.StudioRepository;

@SpringBootApplication
public class TexoApplication {

	@Autowired
	private ProducerRepository producerRepository;
	@Autowired
	private StudioRepository studioRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private MovieProducerRepository movieProducerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TexoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void loadDataAfterStartUp() {
		System.out.println(".........................................................");
		System.out.println("... LOAD DATA BEGIN ..................................");
		System.out.println(".........................................................");

		try {
			File csvFile = ResourceUtils.getFile("classpath:movielist.csv");
            Scanner scanner = new Scanner(csvFile);
            System.out.println("Path to CSV File " + csvFile);

			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine().replace(", and", ",").replace(" and", ",");
				String[] values = line.split(";");
				Integer eventYear = Integer.parseInt(values[0]);
				String movieName = values[1].trim();
				String[] studios = values[2].split(",");
				String[] producers = values[3].split(",");
				Boolean winner = (values.length > 4);

				Movie movie = new Movie(movieName, eventYear, winner);
				movieRepository.save(movie);

				for(String producerName: producers) {
					String name = producerName.trim();
					Producer producer = producerRepository.findByName(name);
					
					if (producer == null) {
						producer = new Producer(name);
						producerRepository.save(producer);
					}

					MovieProducer movieProducer = new MovieProducer(movie, producer);
					movieProducerRepository.save(movieProducer);
				}

				for(String studioName: studios) {
					String name = studioName.trim();
					Studio studio = studioRepository.findByName(name);
					if (studio == null) {
						studioRepository.save(new Studio(name));
					}
				}
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(".........................................................");
		System.out.println("... LOAD DATA FINISH .................................");
		System.out.println(".........................................................");
	}

}
