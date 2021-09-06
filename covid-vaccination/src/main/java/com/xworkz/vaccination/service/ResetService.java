package com.xworkz.vaccination.service;

import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;

public interface ResetService {

	boolean validateLogInDetails(String email, String password, String confirmPassword) throws ServiceException;

	boolean confirmPasswordDetails(String password, String confirmPassword);

	boolean updatePassword(String email, String password) throws DaoException;
	
	boolean updateUnsucessfulLoginAttempt(String email) throws DaoException;

}
