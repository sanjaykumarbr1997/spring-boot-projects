package com.xworkz.vaccination.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccination.dao.OtpDAO;
import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;
import com.xworkz.vaccination.util.OTPGeneratorUtil;
import com.xworkz.vaccination.util.VaccinationEnrollUtil;

@Service
public class OtpServiceImpl implements OtpService {

	public static Map<String, String> map = new HashMap<String, String>();
	private static final Logger logger = Logger.getLogger(OtpServiceImpl.class);

	public OtpServiceImpl() {
		logger.debug(this.getClass().getSimpleName() + " object created");

	}

	@Autowired
	VaccinationEnrollUtil enrollMessage;

	@Autowired
	OtpDAO otpDAO;

	String otpForUser;

	@Override
	public void generateOTP(String email) {
		logger.info("Invoked generateOTP() from OtpServiceImpl");

		enrollMessage.setProperties(email, "OTP for registration",
				"verify you otp in registration page :" + otpForUser);
		System.out.println("mail sending is done");

	}

	@Override
	public boolean validateEmail(String email) {
		logger.info("Invoked validateEmail() from OtpServiceImpl");

		otpForUser = OTPGeneratorUtil.randomPasswordGenerator(4);
		boolean flag = false;
		if (email != null && !email.isEmpty()) {
			flag = true;

		} else {
			map.put("email", "*Email field cant be empty!!!!");
		}
		return flag;

	}

	@Override
	public boolean validateOTP(String otp) {
		logger.info("Invoked validateOTP() from OtpServiceImpl");

		boolean flag = false;
		if (otp != null && !otp.isEmpty()) {
			flag = true;

		} else {
			map.put("otpvalidate", "*OTP field cant be empty!!!!");
		}
		return flag;

	}

	@Override
	public boolean verifyOTP(String otp) {
		logger.info("Invoked verifyOTP() from OtpServiceImpl");

		boolean flag = false;
		if (otp.equals(otpForUser)) {
			flag = true;
		} else {

			map.put("otpverify", "*Incorrect otp!!!!");
		}
		return flag;
	}

	@Override
	public boolean verifyEmailfromDB(String email) throws ServiceException {

		String emailFromDB;
		try {
			logger.info("Invoked verifyOTP() from OtpServiceImpl");
			emailFromDB = otpDAO.verifyEmail(email);
			if (emailFromDB != null && emailFromDB.equals(email)) {
				return true;

			}
			return false;

		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException("Exception occouring in Login Service " + e.getMessage());

		}

	}

}
