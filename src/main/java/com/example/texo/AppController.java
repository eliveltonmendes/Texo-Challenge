package com.example.texo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.texo.dto.AwardIntervalResponseDTO;
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
