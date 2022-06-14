package com.example.texo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.texo.database.repository.ProducerRepository;
import com.example.texo.dto.WinnerProducersDTO;
import com.example.texo.dto.newDto.MoviesDTO;
import com.example.texo.dto.newDto.ProducersDTO;
import com.example.texo.dto.response.AwardIntervalDTO;

@Service
public class AppService {

    @Autowired
    private ProducerRepository producerRepository;

    public List<AwardIntervalDTO> getLongestAwardWinner() {        
        List<AwardIntervalDTO> awardIntervalDTOs = this.getAwardIntervalDTO();
        
        Integer longestInterval = 0;
        for(var dto : awardIntervalDTOs) {
            if (dto.getInterval() == 0) continue;
            if(dto.getInterval() > longestInterval) {
                longestInterval = dto.getInterval();
            }
        }

        List<AwardIntervalDTO> maxResult = new ArrayList<>();
        for(var dto : awardIntervalDTOs) {
            if (dto.getInterval() == longestInterval) {
                maxResult.add(dto);
            }
        }
        return maxResult;
    }

    public List<AwardIntervalDTO> getShortestAwardWinner() {
        List<AwardIntervalDTO> awardIntervalDTOs = this.getAwardIntervalDTO();

        Integer shortestInterval = 99;
        for(var dto : awardIntervalDTOs) {
            if (dto.getInterval() == 0) continue;
            if(dto.getInterval() < shortestInterval) {
                shortestInterval = dto.getInterval();
            }
        }

        List<AwardIntervalDTO> minResult = new ArrayList<>();
        for(var dto : awardIntervalDTOs) {
            if (dto.getInterval() == shortestInterval) {
                minResult.add(dto);
            }
        }

        return minResult;
    }

    private List<AwardIntervalDTO> getAwardIntervalDTO() {
        List<WinnerProducersDTO> producersWhoWon = producerRepository.findProducerWithWinnerMovies();
        List<ProducersDTO> movieWinners = producerRepository.findMovieWinners();
        List<ProducersDTO> producers = new ArrayList<>();
        for (WinnerProducersDTO winnerProducersDTO : producersWhoWon) {
            List<ProducersDTO> producerMovies = movieWinners.stream()
               .filter(o -> o.getProducer().equals(winnerProducersDTO.getName()))
               .collect(Collectors.toList());
            
            List<MoviesDTO> movies = new ArrayList<>();
            for(ProducersDTO movie : producerMovies) {
                movies.add(new MoviesDTO(movie.getMovie(), movie.getYear()));
            }

            ProducersDTO producer = new ProducersDTO(winnerProducersDTO.getName(), movies);
            producers.add(producer);
        }

        List<AwardIntervalDTO> awardIntervalDTOs = new ArrayList<>();
        for (var producer: producers ) {
            for (int i = 0; i < producer.getMovies().size(); i++) {
                try{
                    MoviesDTO previousMovie = producer.getMovies().get(i);
                    MoviesDTO followinMovie = producer.getMovies().get(i + 1);
                    if (followinMovie != null) {
                        Integer interval = (followinMovie.getYear() - previousMovie.getYear());
                        AwardIntervalDTO award = new AwardIntervalDTO(producer.getProducer(), interval, previousMovie.getYear(), followinMovie.getYear());
                        awardIntervalDTOs.add(award);
                    }
                } catch(IndexOutOfBoundsException e) {
                    continue;
                }
            }
        }

        return awardIntervalDTOs;
    }
}
