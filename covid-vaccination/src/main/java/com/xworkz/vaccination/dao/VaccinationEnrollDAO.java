package com.xworkz.vaccination.dao;

import com.xworkz.vaccination.entity.VaccinationEntity;
import com.xworkz.vaccination.exceptions.DaoException;

public interface VaccinationEnrollDAO {

	boolean saveDetails(VaccinationEntity vaccinationEntity) throws DaoException;

}
