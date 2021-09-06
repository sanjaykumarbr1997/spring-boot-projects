package com.xworkz.vaccination.util;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderDecoderUtil {
	private static final Logger logger = Logger.getLogger(PasswordEncoderDecoderUtil.class);

	public static String encodePassword(String rawPassword) {
		logger.info("Invoked encodePassword() from PasswordEncoderDecoderUtil");

		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
		return bcryptEncoder.encode(rawPassword);

	}

	public static boolean decodePassword(String rawPassword, String passwordFromDB) {
		logger.info("Invoked decodePassword() from PasswordEncoderDecoderUtil");

		BCryptPasswordEncoder bcryptDecoder = new BCryptPasswordEncoder();
		return bcryptDecoder.matches(rawPassword, passwordFromDB);

	}

}
