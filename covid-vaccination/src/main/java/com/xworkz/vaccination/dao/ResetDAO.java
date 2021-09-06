package com.xworkz.vaccination.dao;

import com.xworkz.vaccination.exceptions.DaoException;

public interface ResetDAO {

	boolean updatePassword(String email, String password) throws DaoException;

	boolean updateUnsucessfulLoginAttempt(String email, int noOfUnsuccesfulAttempts) throws DaoException;

}
