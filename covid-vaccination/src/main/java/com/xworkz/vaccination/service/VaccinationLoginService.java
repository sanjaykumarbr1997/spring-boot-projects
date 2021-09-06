package com.xworkz.vaccination.service;

import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;

public interface VaccinationLoginService {

	boolean validateLogInDetails(String email, String password) throws ServiceException;

	boolean getLogInDetails(String email, String password) throws ServiceException, DaoException;
	
	boolean checkUnsuccessfulAttempts(String email) throws DaoException;


	
	
	
	

}
