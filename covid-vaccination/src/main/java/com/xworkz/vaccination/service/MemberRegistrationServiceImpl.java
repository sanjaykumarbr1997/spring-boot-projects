package com.xworkz.vaccination.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vaccination.dao.MemberDetailsRegistrationDAO;
import com.xworkz.vaccination.dao.VaccinationLoginDAOImpl;
import com.xworkz.vaccination.dto.MemberDetailsDTO;
import com.xworkz.vaccination.entity.MemberDetailsEntity;
import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;

@Service
public class MemberRegistrationServiceImpl implements MemberRegistrationService {
	private static final Logger logger = Logger.getLogger(MemberRegistrationServiceImpl.class);

	public MemberRegistrationServiceImpl() {
		logger.debug(this.getClass().getSimpleName() + " object created");
	}

	int noOfMemberRegistered;

	public static Map<String, String> mapping = new HashMap<String, String>();

	@Autowired
	private VaccinationLoginServiceImpl vaccinationServiceImpl;

	@Autowired
	private MemberDetailsRegistrationDAO memberDAO;

	@Override
	public boolean validate(MemberDetailsDTO memberDTO) throws ServiceException {
		boolean flag = false;

		try {
			logger.info("Invoked validate() from MemberRegistrationServiceImpl");

			if (memberDTO.getNameOfMember() != null && !memberDTO.getNameOfMember().isEmpty()
					&& memberDTO.getAadharOfMember() != null && !memberDTO.getAadharOfMember().isEmpty()
					&& memberDTO.getGenderOfMember() != null && !memberDTO.getGenderOfMember().isEmpty()
					&& memberDTO.getMobileNoOfMember() != null && !memberDTO.getMobileNoOfMember().isEmpty()
					&& memberDTO.getTypeOfVaccine() != null && !memberDTO.getTypeOfVaccine().isEmpty()) {
				flag = true;

			} else {
				mapping.put("name", "*Name field cant be empty!!!!");
				mapping.put("aadhar", "*Aadhar field cant be empty!!!!");
				mapping.put("mobile", "*Mobile field cant be empty!!!!");
				mapping.put("gender", "*Gender cant be empty!!!!");
				mapping.put("type", "*Type of field cant be empty!!!!");

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Error in  validate() from MemberRegistrationServiceImpl");

			throw new ServiceException(e.getMessage());

		}

		return flag;

	}

	@Override
	public List<Object> getAllDetails() throws ServiceException {
		try {
			logger.info("Invoked getAllDetails() from MemberRegistrationServiceImpl");

			List<MemberDetailsEntity> memberEntityList = this.memberDAO.fetchAllDetails();
			return new ArrayList<Object>(memberEntityList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Error in  getAllDetails() from MemberRegistrationServiceImpl");

			throw new ServiceException(e.getMessage());
		}

	}

	@Override
	public boolean checkNoOfMembersRegistered() throws ServiceException {
		try {
			logger.info("Invoked checkNoOfMembersRegistered() from MemberRegistrationServiceImpl");

			noOfMemberRegistered = this.memberDAO.getUserDetails(vaccinationServiceImpl.userEmail);

			if (noOfMemberRegistered < 4) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Error in  checkNoOfMembersRegistered() from MemberRegistrationServiceImpl");

			throw new ServiceException(e.getMessage());
		}

	}

	@Override
	public boolean saveMemberDetailsDTO(MemberDetailsDTO memberDTO) throws ServiceException {
		System.out.println(memberDTO);

		MemberDetailsEntity memberEntity = new MemberDetailsEntity();

		BeanUtils.copyProperties(memberDTO, memberEntity);
		System.out.println("details copied to entity" + memberEntity);
		boolean detailsSaved;

		try {
			logger.info("Invoked saveMemberDetailsDTO() from MemberRegistrationServiceImpl");

			detailsSaved = memberDAO.saveDetails(memberEntity);

			if (detailsSaved) {
				int noOfRegisteredUsers = noOfMemberRegistered;
				noOfRegisteredUsers++;
				this.memberDAO.updateNoOfRegistered(vaccinationServiceImpl.userEmail, noOfRegisteredUsers);

				return true;
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Error in  saveMemberDetailsDTO() from MemberRegistrationServiceImpl");

			throw new ServiceException(e.getMessage());
		}

	}

	@Override
	public MemberDetailsEntity getDetailsById(int id) throws ServiceException {

		try {
			logger.info("Invoked getDetailsById() from MemberRegistrationServiceImpl");

			return memberDAO.getMemberDetails(id);

		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Error in  getDetailsById() from MemberRegistrationServiceImpl");

			throw new ServiceException(e.getMessage());

		}

	}

	public void updateDetailsByAadhar(String aadhar, MemberDetailsDTO memberDto) throws ServiceException {

		try {
			MemberDetailsEntity memberEntity = new MemberDetailsEntity();
			BeanUtils.copyProperties(memberDto, memberEntity);
			memberDAO.updateDetailsByAadhar(aadhar, memberEntity);
			logger.info("Invoked updateDetailsByAadhar() from MemberRegistrationServiceImpl");

		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Error in  updateDetailsByAadhar() from MemberRegistrationServiceImpl");

			throw new ServiceException(e.getMessage());

		}

	}

	@Override
	public void deleteDetailsByAadhar(String aadhar) throws ServiceException {
		try {
			logger.info("Invoked deleteDetailsByAadhar() from MemberRegistrationServiceImpl");

			memberDAO.deleteDetailsByAadhar(aadhar);
		} catch (Exception e) {
			e.printStackTrace();
			logger.warn("Error in  deleteDetailsByAadhar() from MemberRegistrationServiceImpl");

			throw new ServiceException(e.getMessage());

		}

	}

}
