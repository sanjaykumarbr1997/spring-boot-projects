package com.xworkz.vaccination.dao;

import java.util.List;

import com.xworkz.vaccination.dto.MemberDetailsDTO;
import com.xworkz.vaccination.entity.MemberDetailsEntity;
import com.xworkz.vaccination.exceptions.DaoException;

public interface MemberDetailsRegistrationDAO {

	public boolean saveDetails(MemberDetailsEntity memberEntity) throws DaoException;

	public List<MemberDetailsEntity> fetchAllDetails();

	public void updateNoOfRegistered(String emailOfUser, int noOfRegisteredUsers);

	public int getUserDetails(String userEmail);

	public MemberDetailsEntity getMemberDetails(int id);

	public void updateDetailsByAadhar( String aadhar,MemberDetailsEntity memberEntity);

	public void deleteDetailsByAadhar(String aadhar);


}
