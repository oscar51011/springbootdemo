package com.demo.testing.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.testing.dao.PlayerDao;
import com.demo.testing.model.Player;

/**
 * 實現玩家服務
 * @author oscar51011
 * @date 2022年3月9日
 */
public class PlayerServiceImpl implements IPlayerService {
	
	@Autowired
	private PlayerDao playerDao;

	@Override
	public boolean isPlayerAnAdult(long id) {
		
		Player player = playerDao.getPlayerById(id);
		if(player == null ) throw new RuntimeException("Player Not Found!");
		
		if(player.getAge() >= 18 )
			return true;
		
		return false;
	}
	
}
