package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.truyum.controller.CartController;

public class DateUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	public static Date convertToDate(String date) {
		LOGGER.info("START");
		Date dateFormatter = null;
		try {
			dateFormatter = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOGGER.info("END");
		return dateFormatter;
	}
}