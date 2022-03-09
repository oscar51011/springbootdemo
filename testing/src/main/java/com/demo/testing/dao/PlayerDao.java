package com.demo.testing.dao;

import com.demo.testing.model.Player;

/**
 * 描述DAO 的介面
 * @author oscar51011
 * @date 2022年3月9日
 */
public interface PlayerDao {
	Player getPlayerById(long id);
}
