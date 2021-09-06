package com.xworkz.vaccination.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class VaccinationDTO implements Serializable {

	private int id;
	private String name;
	private String email;
	private String password;
	private String mobileNo;
	private String typeOfVaccine;
	private String otp;
	private String gender;

}
