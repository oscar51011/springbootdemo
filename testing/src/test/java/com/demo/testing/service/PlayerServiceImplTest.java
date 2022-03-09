package com.demo.testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.testing.dao.PlayerDao;
import com.demo.testing.model.Player;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PlayerServiceImplTest {
	
	@Mock
	private PlayerDao playerDao;
	
	@InjectMocks
	private PlayerServiceImpl playerService;
	
	/**
	 * 測試玩家大於等於18歲, 要回傳 true
	 */
	@Test
	void testIsPlayerAnAdult_PlayerIsAnAdult() {
		
		// Arrange
		Mockito.when(playerDao.getPlayerById(1L)).thenReturn(new Player("Oscar", 19));
		
		// act
		boolean isPlayerAnAdult = playerService.isPlayerAnAdult(1L);
		
		// assert
		assertEquals(isPlayerAnAdult, true);
		
	}
	
	/**
	 * 測試玩家小於18歲 , 要回傳 false
	 */
	@Test
	void testIsPlayerAnAdult_PlayerIsNotAnAdult() {
		
		// Arrange
		Mockito.when(playerDao.getPlayerById(1L)).thenReturn(new Player("Oscar", 17));
		
		// act
		boolean isPlayerAnAdult = playerService.isPlayerAnAdult(1L);
		
		// assert
		assertEquals(isPlayerAnAdult, false);
		
	}
	
	/**
	 * 測試如果找不到玩家，要拋出 Exception
	 */
	@Test
	void testIsPlayerAnAdult_PlayerNotFound() {
		
		// assert
		assertThrows(RuntimeException.class,
			()->{
				// Arrange
				Mockito.when(playerDao.getPlayerById(1L)).thenReturn(null);
				
				// act
				playerService.isPlayerAnAdult(1L);
			}
		);
		
	}

}
