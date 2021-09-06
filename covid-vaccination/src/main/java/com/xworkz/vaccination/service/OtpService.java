package com.xworkz.vaccination.service;

import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;

public interface OtpService {

	public boolean validateEmail(String email);

	public void generateOTP(String email) throws ServiceException;

	public boolean validateOTP(String otp);

	public boolean verifyOTP(String otp);

	public boolean verifyEmailfromDB(String email) throws ServiceException, DaoException ;

}
