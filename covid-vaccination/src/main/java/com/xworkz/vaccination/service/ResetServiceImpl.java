package com.xworkz.vaccination.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccination.dao.ResetDAO;
import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;
import com.xworkz.vaccination.util.PasswordEncoderDecoderUtil;

@Service
public class ResetServiceImpl implements ResetService {
	private static final Logger logger = Logger.getLogger(ResetServiceImpl.class);

	public ResetServiceImpl() {
		logger.debug(this.getClass().getSimpleName() + " object created");
	}

	@Autowired
	private ResetDAO resetDAO;

	public static Map<String, String> map = new HashMap<String, String>();

	public boolean validateLogInDetails(String email, String password, String confirmPassword) throws ServiceException {

		logger.info("Invoked validateLogInDetails() from ResetServiceImpl");
		boolean flag = false;
		if (!email.isEmpty() && email != null && !password.isEmpty() && password != null && !confirmPassword.isEmpty()
				&& confirmPassword != null) {
			flag = true;
		} else {
			map.put("email", "*Email field cant be empty!!!!");
			map.put("password", "*password field cant be empty!!!!");
			map.put("confirmPassword", "*confirm password field cant be empty!!!!");

		}

		return flag;
	}

	@Override
	public boolean confirmPasswordDetails(String password, String confirmPassword) {
		logger.info("Invoked confirmPasswordDetails() from ResetServiceImpl");
		if (password.equals(confirmPassword)) {

			return true;
		}
		return false;
	}

	@Override
	public boolean updatePassword(String email, String password) throws DaoException {
		logger.info("Invoked updatePassword() from ResetServiceImpl");

		String passwordEncoded = PasswordEncoderDecoderUtil.encodePassword(password);
		return this.resetDAO.updatePassword(email, passwordEncoded);
	}

	@Override
	public boolean updateUnsucessfulLoginAttempt(String email) throws DaoException {
		logger.info("Invoked updateUnsucessfulLoginAttempt() from ResetServiceImpl");

		return this.resetDAO.updateUnsucessfulLoginAttempt(email, 0);

	}

}
