package com.cognizant.truyum.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> MENU_ITEMS;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);

	public MenuItemDaoCollectionImpl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		MENU_ITEMS = context.getBean("menuItems", ArrayList.class);
		LOGGER.debug("MenuItems:{}", MENU_ITEMS);
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("START");
		List<MenuItem> menuItemListCustomer = new ArrayList<MenuItem>();
		LocalDateTime localDateTime = LocalDateTime.now();
		String format = DateTimeFormatter.ofPattern("dd/mm/yyyy", Locale.ENGLISH).format(localDateTime);
		Date currentSystemDate = DateUtil.convertToDate(format);

		for (MenuItem menuItemIterator : MENU_ITEMS) {
			if ((menuItemIterator.isActive() == true)
					&& (menuItemIterator.getDateOfLaunch().compareTo(currentSystemDate) < 0)) {
				menuItemListCustomer.add(menuItemIterator);

			}
		}
		LOGGER.info("END");
		return menuItemListCustomer;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("START");
		try {
			MenuItem menuItem1 = getMenuItem(menuItem.getId());
			menuItem1.setName(menuItem.getName());
			menuItem1.setPrice(menuItem.getPrice());
			menuItem1.setActive(menuItem.isActive());
			menuItem1.setFreeDelivery(menuItem.isFreeDelivery());
			menuItem1.setCategory(menuItem.getCategory());
			menuItem1.setDateOfLaunch(menuItem.getDateOfLaunch());
			menuItem1.setFreeDelivery(menuItem.isFreeDelivery());

		} catch (MenuItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("END");
	}

	@Override
	public MenuItem getMenuItem(long id) throws MenuItemNotFoundException {
		LOGGER.info("START");
		LOGGER.info("END");
		for (MenuItem menuItem : MENU_ITEMS) {
			if (menuItem.getId() == id)
				return menuItem;
			else
				throw new MenuItemNotFoundException();
		}
		return null;
	}

}
