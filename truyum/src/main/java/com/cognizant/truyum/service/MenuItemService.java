package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {
	@Autowired
	private MenuItemDao menuItemDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);

	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemDao.getMenuItemListCustomer();
	}

	public MenuItem getMenuItemById(long id) throws MenuItemNotFoundException {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemDao.getMenuItem(id);
	}

	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start");
		LOGGER.info("End");
		menuItemDao.modifyMenuItem(menuItem);
	}
}