package com.demo.testing.dao;

import com.demo.testing.model.Player;

/**
 * 實作 player DAO
 * @author oscar51011
 * @date 2022年3月9日
 */
public class PlayerDaoImpl implements PlayerDao {

	@Override
	public Player getPlayerById(long id) {
		Player player = new Player("Oscar", 19);
		return player;
	}

}
