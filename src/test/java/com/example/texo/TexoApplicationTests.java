package com.example.texo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.texo.dto.AwardIntervalDTO;
import com.example.texo.service.AppService;

@SpringBootTest
class TexoApplicationTests {

	@Autowired
	private AppService appService;

	@Test
	public void shouldReturnMinResult() {
		var minResult = appService.getShortestAwardWinner();
		var firstResult = minResult.get(0);

		AwardIntervalDTO expectedResult = new AwardIntervalDTO("Joel Silver", 1, 1990, 1991);

		assertEquals(minResult.size(), 1);
		assertEquals(firstResult.getProducer(), expectedResult.getProducer());
		assertEquals(firstResult.getPreviousWin(), expectedResult.getPreviousWin());		
		assertEquals(firstResult.getFollowinWin(), expectedResult.getFollowinWin());
		assertEquals(firstResult.getInterval(), expectedResult.getInterval());
	}

	@Test
	public void shouldReturnMax() {
		var maxResult = appService.getLongestAwardWinner();
		var firstResult = maxResult.get(0);

		AwardIntervalDTO expectedResult = new AwardIntervalDTO("Matthew Vaughn", 13, 2002, 2015);

		assertEquals(maxResult.size(), 1);
		assertEquals(expectedResult.getProducer(), firstResult.getProducer());
		assertEquals(expectedResult.getPreviousWin(), firstResult.getPreviousWin());
		assertEquals(expectedResult.getFollowinWin(), firstResult.getFollowinWin());
		assertEquals(expectedResult.getInterval(), firstResult.getInterval());
	}

}
