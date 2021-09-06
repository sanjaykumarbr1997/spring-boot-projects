package com.xworkz.vaccination.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccination.dao.VaccinationEnrollDAO;
import com.xworkz.vaccination.dto.VaccinationDTO;
import com.xworkz.vaccination.entity.VaccinationEntity;
import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;
import com.xworkz.vaccination.util.PasswordEncoderDecoderUtil;
import com.xworkz.vaccination.util.VaccinationEnrollUtil;

@Service
public class VaccinationEnrollServiceImpl implements VaccinationEnrollService {
	private static final Logger logger = Logger.getLogger(VaccinationEnrollServiceImpl.class);

	public static Map<String, String> map = new HashMap<String, String>();

	@Autowired
	private VaccinationEnrollDAO vaccinationDAO;

	@Autowired
	private VaccinationEnrollUtil enrollSendMessage;

	public boolean saveDTO(VaccinationDTO vaccinationDTO) throws ServiceException {

		VaccinationEntity vaccinationEntity = new VaccinationEntity();
		vaccinationEntity.setNoOfLoginAttempts(0);
		vaccinationEntity.setNoOfMembersRegistered(0);

		String userPassword = vaccinationDTO.getPassword();

		String passwordEncoded = PasswordEncoderDecoderUtil.encodePassword(userPassword);
		BeanUtils.copyProperties(vaccinationDTO, vaccinationEntity);
		vaccinationEntity.setPassword(passwordEncoded);

		boolean result;
		try {
			logger.info("Invoked saveDTO() from VaccinationEnrollServiceImpl");

			result = vaccinationDAO.saveDetails(vaccinationEntity);

			if (result) {
				logger.info("mail sending started");

				enrollSendMessage.setProperties(vaccinationDTO.getEmail(), "Sign in Confirmation",
						"Thank you for enrolling " + vaccinationDTO.getName()
								+ " Please use the provided password to login : " + vaccinationDTO.getPassword());

				logger.info("mail sending is done");
				return true;
			} else {
				logger.warn("Error in sending mail ");
				return false;
			}
		} catch (DaoException e) {
			e.printStackTrace();
			logger.warn("Error in sending mail from VaccinationEnrollServiceImpl");

			throw new ServiceException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public boolean validate(VaccinationDTO vaccinationDTO) throws ServiceException {
		boolean flag = false;

		if (vaccinationDTO.getName() != null && !vaccinationDTO.getName().isEmpty() && vaccinationDTO.getEmail() != null
				&& !vaccinationDTO.getEmail().isEmpty() && vaccinationDTO.getMobileNo() != null
				&& !vaccinationDTO.getMobileNo().isEmpty() && vaccinationDTO.getPassword() != null
				&& !vaccinationDTO.getPassword().isEmpty() && vaccinationDTO.getTypeOfVaccine() != null
				&& !vaccinationDTO.getTypeOfVaccine().isEmpty() && vaccinationDTO.getGender() != null
				&& !vaccinationDTO.getGender().isEmpty()) {
			logger.info("Invoked validate() from VaccinationEnrollServiceImpl");
			flag = true;

		} else {
			map.put("name", "*Name field cant be empty!!!!");
			map.put("email", "*Email field cant be empty!!!!");
			map.put("password", "*Password field cant be empty!!!!");
			map.put("mobile", "*Mobile field cant be empty!!!!");
			map.put("gender", "*Gender cant be empty!!!!");
			map.put("type", "*Type of field cant be empty!!!!");
			logger.warn("Error in validate() from VaccinationEnrollServiceImpl");

		}
		return flag;

	}

}
