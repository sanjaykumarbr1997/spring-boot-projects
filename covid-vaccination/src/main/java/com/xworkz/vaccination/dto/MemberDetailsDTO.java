package com.xworkz.vaccination.dto;

import java.io.Serializable;



import lombok.Data;
import lombok.Getter;

@Data
public class MemberDetailsDTO implements Serializable {

	private int id;
	private String nameOfMember;
	private String genderOfMember;
	private String aadharOfMember;
	private String mobileNoOfMember;
	private String typeOfVaccine;
	

}
