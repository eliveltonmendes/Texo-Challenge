package com.example.texo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.texo.database.entity.Movie;
import com.example.texo.database.repository.MovieRepository;
import com.example.texo.database.repository.ProducerRepository;
import com.example.texo.dto.AwardIntervalDTO;
import com.example.texo.dto.AwardIntervalResponseDTO;
import com.example.texo.dto.AwardWinnerDTO;
import com.example.texo.dto.WinnerProducersDTO;
import com.example.texo.service.AppService;

@ControllerAdvice
@RestController
@RequestMapping(value = { "/" })
public class AppController {

    @Autowired
    private AppService appService;

    @GetMapping("/movies/awardsinterval")
	public AwardIntervalResponseDTO listForAwardsInterval() {
        var maxResult = appService.getLongestAwardWinner();
        var minResult = appService.getShortestAwardWinner();

        AwardIntervalResponseDTO response = new AwardIntervalResponseDTO();
        response.setMax(maxResult);
        response.setMin(minResult);

        return response;
    }
}
