package com.xworkz.vaccination.service;

import com.xworkz.vaccination.dto.VaccinationDTO;
import com.xworkz.vaccination.exceptions.ServiceException;

public interface VaccinationEnrollService {

	boolean validate(VaccinationDTO vaccinationDTO) throws ServiceException;

	boolean saveDTO(VaccinationDTO vaccinationDTO) throws ServiceException;
	

}
