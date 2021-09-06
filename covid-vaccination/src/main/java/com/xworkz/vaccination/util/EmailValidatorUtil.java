package com.xworkz.vaccination.util;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;


public class EmailValidatorUtil {
	private static final Logger logger = Logger.getLogger(EmailValidatorUtil.class);

	public static boolean isValidEmailAddress(String email) {

		boolean result = true;
		try {
			logger.info("Invoked isValidEmailAddress() from EmailValidatorUtil");

			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			logger.warn("Error in isValidEmailAddress() from EmailValidatorUtil");
			result = false;
		}
		return result;
	}

}
