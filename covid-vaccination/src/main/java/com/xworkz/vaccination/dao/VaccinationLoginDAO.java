package com.xworkz.vaccination.dao;

import com.xworkz.vaccination.entity.VaccinationEntity;
import com.xworkz.vaccination.exceptions.DaoException;

public interface VaccinationLoginDAO {

	public VaccinationEntity verify(String email) throws DaoException;

	public void updateAttempt(int noOfUnsuccesfulLoginAttemp, String email) throws DaoException;

	public int getUnsuccessfulAttempt(String email) throws DaoException;


}
