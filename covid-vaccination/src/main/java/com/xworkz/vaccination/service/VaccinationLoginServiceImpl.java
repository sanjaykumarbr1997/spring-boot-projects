package com.xworkz.vaccination.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xworkz.vaccination.dao.VaccinationLoginDAO;
import com.xworkz.vaccination.entity.VaccinationEntity;
import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;
import com.xworkz.vaccination.util.PasswordEncoderDecoderUtil;

@Service
public class VaccinationLoginServiceImpl implements VaccinationLoginService {
	public static Map<String, String> map = new HashMap<String, String>();
	private static final Logger logger = Logger.getLogger(VaccinationLoginServiceImpl.class);

	public static String userName;
	public static String userEmail;
	public static int noOfRegisteredMembers;

	@Autowired
	private VaccinationLoginDAO vaccinationLoginDAO;

	@Override
	public boolean validateLogInDetails(String email, String passwordDetails) throws ServiceException {
		System.out.println("Invoked validateLogInDetails ");
		boolean flag = false;
		logger.info("Invoked validateLogInDetails() from VaccinationLoginServiceImpl");

		if (!email.isEmpty() && email != null && !passwordDetails.isEmpty() && passwordDetails != null) {

			flag = true;
		} else {
			map.put("email", "*Email field cant be empty!!!!");
			map.put("password", "*password field cant be empty!!!!");

		}

		return flag;
	}

	int noOfAttempts;

	@Override
	public boolean checkUnsuccessfulAttempts(String email) throws DaoException {
		logger.info("Invoked checkUnsuccessfulAttempts() from VaccinationLoginServiceImpl");

		noOfAttempts = vaccinationLoginDAO.getUnsuccessfulAttempt(email);
		if (noOfAttempts < 3) {

			return true;
		}
		return false;
	}

	@Override
	public boolean getLogInDetails(String email, String passwordDetails) throws ServiceException, DaoException {
		logger.info("Invoked getLogInDetails() from VaccinationLoginServiceImpl");

		VaccinationEntity entity = vaccinationLoginDAO.verify(email);
		userName = entity.getName();
		userEmail = entity.getEmail();
		noOfRegisteredMembers = entity.getNoOfMembersRegistered();

		boolean passwordCheck = PasswordEncoderDecoderUtil.decodePassword(passwordDetails, entity.getPassword());
		boolean flag = false;

		if (passwordCheck) {
			flag = true;
			return true;

		} else {
			map.put("errorverification", "*Incorrect Email or Password!!!!");
			int noOfUnsuccesfulLoginAttemp = noOfAttempts;
			noOfUnsuccesfulLoginAttemp++;
			this.vaccinationLoginDAO.updateAttempt(noOfUnsuccesfulLoginAttemp, email);

		}
		return flag;

	}

}
