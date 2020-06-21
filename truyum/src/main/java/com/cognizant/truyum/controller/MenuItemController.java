package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	@GetMapping
	public List<MenuItem> getAllMenuItems(){
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemService.getMenuItemListCustomer();
	}
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id) throws MenuItemNotFoundException {
		return menuItemService.getMenuItemById(id);
	}
	@PutMapping
	public void menuItemModifyMenuItem(@RequestBody MenuItem menuItem) {
	menuItemService.modifyMenuItem(menuItem);	
	}
}
