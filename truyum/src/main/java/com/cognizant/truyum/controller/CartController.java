package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	private CartService cartService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@PostMapping("/{userId}/{menuItemId}")
	public void addcartItem(@PathVariable String userId, @PathVariable long menuItemId) {
		LOGGER.info("START");
		
		try {
			cartService.addCartItem(userId, menuItemId);
		} catch (MenuItemNotFoundException e) {
			e.printStackTrace();
		}
		LOGGER.info("END");
	}

	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable String userId) {
		LOGGER.info("START");
		LOGGER.info("End");
		return cartService.getAllCartItems(userId);
	}

	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable String userId, @PathVariable long menuItemId) {
		LOGGER.info("START");
		
		try {
			cartService.deleteMenuItem(userId, menuItemId);
		} catch (MenuItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("END");
	}
}