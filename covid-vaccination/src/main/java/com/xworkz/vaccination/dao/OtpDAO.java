package com.xworkz.vaccination.dao;

import com.xworkz.vaccination.exceptions.DaoException;

public interface OtpDAO {

	String verifyEmail(String email) throws DaoException;

}
