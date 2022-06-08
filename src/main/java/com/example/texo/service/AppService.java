package com.example.texo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.texo.database.repository.ProducerRepository;
import com.example.texo.dto.AwardIntervalDTO;
import com.example.texo.dto.WinnerProducersDTO;

@Service
public class AppService {

    @Autowired
    private ProducerRepository producerRepository;
    //2 - e o que obteve dois prêmios mais rápido,

    public List<AwardIntervalDTO> getLongestAwardWinner() {
        List<WinnerProducersDTO> winners = producerRepository.findProducerwinner();
        Integer longestInterval = 13;
        
        for(var dto : winners) {
            if (dto.getInterval() == 0) continue;
            if(dto.getInterval() > longestInterval) {
                longestInterval = dto.getInterval();
            }
        }

        //1 - Obter o produtor com maior intervalo entre dois prêmios consecutivos, 
        List<WinnerProducersDTO> longestProducers = new ArrayList<>();
        for(var dto : winners) {
            if (dto.getInterval() == longestInterval) {
                longestProducers.add(dto);
            }
        }

        List<AwardIntervalDTO> maxResult = new ArrayList<>();
        for(var dto : longestProducers) {
            AwardIntervalDTO intervalDto = new AwardIntervalDTO(dto.getName(), dto.getInterval(), dto.getMinimo(), dto.getMaximo());
            maxResult.add(intervalDto);
        }
        return maxResult;
    }

    public List<AwardIntervalDTO> getShortestAwardWinner() {
        List<WinnerProducersDTO> winners = producerRepository.findProducerwinner();
        Integer shortestInterval = 99;
        for(var dto : winners) {
            if (dto.getInterval() == 0) continue;
            if(dto.getInterval() < shortestInterval) {
                shortestInterval = dto.getInterval();
            }
        }

        List<WinnerProducersDTO> shortestProducers = new ArrayList<>();
        for(var dto : winners) {
            if (dto.getInterval() == shortestInterval) {
                shortestProducers.add(dto);
            }
        }

        List<AwardIntervalDTO> minResult = new ArrayList<>();
        for(var dto : shortestProducers) {
            AwardIntervalDTO intervalDto = new AwardIntervalDTO(dto.getName(), dto.getInterval(), dto.getMinimo(), dto.getMaximo());
            minResult.add(intervalDto);
        }
        return minResult;
    }
}
