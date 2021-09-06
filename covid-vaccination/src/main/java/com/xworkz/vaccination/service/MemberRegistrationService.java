package com.xworkz.vaccination.service;

import java.util.List;

import com.xworkz.vaccination.dto.MemberDetailsDTO;
import com.xworkz.vaccination.entity.MemberDetailsEntity;
import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;

public interface MemberRegistrationService {

	public boolean validate(MemberDetailsDTO memberDTO) throws ServiceException, DaoException;

	public boolean saveMemberDetailsDTO(MemberDetailsDTO memberDTO) throws ServiceException;

	public List<Object> getAllDetails() throws ServiceException;

	public boolean checkNoOfMembersRegistered() throws ServiceException ;

	public MemberDetailsEntity getDetailsById(int id) throws ServiceException ;

	public void updateDetailsByAadhar(String aadhar, MemberDetailsDTO memberDto) throws ServiceException;

	public void deleteDetailsByAadhar(String aadhar) throws ServiceException;

}
