package com.xworkz.vaccination.util;

import java.security.SecureRandom;

import org.apache.log4j.Logger;

public class OTPGeneratorUtil {
	private static final Logger logger = Logger.getLogger(OTPGeneratorUtil.class);

	private static final String DIGIT = "0123456789";

	private static SecureRandom random = new SecureRandom();

	public static String randomPasswordGenerator(int passwordLength) {
		return generateStrongPassword(passwordLength);
	}

	public static String generateStrongPassword(int passwordLength) {
		logger.info("Invoked generateStrongPassword() from OTPGeneratorUtil");

		StringBuilder result = new StringBuilder(passwordLength);

		String strDigit = generateRandomString(DIGIT, 4);
		result.append(strDigit);
		String password = result.toString();
		return password;
	}

	private static String generateRandomString(String input, int size) {

		if (input == null || input.length() <= 0)
			System.out.println("invalid input");
		if (size < 1)
			System.out.println("invalid size");

		StringBuilder result1 = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			int index = random.nextInt(input.length());
			result1.append(input.charAt(index));
		}
		return result1.toString();
	}

}
