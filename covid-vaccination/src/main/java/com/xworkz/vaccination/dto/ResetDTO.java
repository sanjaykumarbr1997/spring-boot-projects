package com.xworkz.vaccination.dto;

import lombok.Data;

@Data
public class ResetDTO {

	private String email;
	private String password;
	private String confirmPassword;

}
