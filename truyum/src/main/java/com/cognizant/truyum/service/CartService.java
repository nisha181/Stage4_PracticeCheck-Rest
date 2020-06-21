package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {
	@Autowired
	private CartDao cartdao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);

	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		LOGGER.info("START");
		try {
			cartdao.addCartItem(userId, menuItemId);
		} catch (MenuItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("END");
	}

	public List<MenuItem> getAllCartItems(String userId) {
		LOGGER.info("START");
		LOGGER.info("END");
		return cartdao.getAllCartItems(userId);
	}

	public void deleteMenuItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		LOGGER.info("START");
		cartdao.removeCartItem(userId, menuItemId);
		LOGGER.info("END");
	}
}