package com.xworkz.vaccination.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.xworkz.vaccination.dto.ResetDTO;
import com.xworkz.vaccination.exceptions.ControllerException;
import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;
import com.xworkz.vaccination.service.OtpService;
import com.xworkz.vaccination.service.ResetService;
import com.xworkz.vaccination.service.ResetServiceImpl;

@Controller
public class ResetController {
	private static final Logger logger=Logger.getLogger(ResetController.class);


	Map<String, String> map = ResetServiceImpl.map;

	public ResetController() {
		logger.debug(this.getClass().getSimpleName() + " created");
	}

	@Autowired
	private ResetService resetService;

	@Autowired
	private OtpService otpService;

	@GetMapping("/getResetPage.all")
	public String resetPasswordPage() {

		return "Reset";

	}

	@PostMapping("/reset.all")
	public ModelAndView resetPassword(@ModelAttribute ResetDTO resetDTO) throws ControllerException, DaoException {
		logger.info("invoked resetPassword()");
		boolean validateDetails;
		boolean checkConfirmPassword;
		boolean updateNewPassword;
		boolean verifyEmailInDB;
		boolean updateLoginAttempt;

		try {

			validateDetails = resetService.validateLogInDetails(resetDTO.getEmail(), resetDTO.getEmail(),
					resetDTO.getConfirmPassword());
			if (validateDetails) {
				checkConfirmPassword = resetService.confirmPasswordDetails(resetDTO.getPassword(),
						resetDTO.getConfirmPassword());
				if (checkConfirmPassword) {

					verifyEmailInDB = this.otpService.verifyEmailfromDB(resetDTO.getEmail());
					if (verifyEmailInDB) {

						updateNewPassword = this.resetService.updatePassword(resetDTO.getEmail(),
								resetDTO.getPassword());
						if (updateNewPassword) {

							updateLoginAttempt = this.resetService.updateUnsucessfulLoginAttempt(resetDTO.getEmail());
							if (updateLoginAttempt) {
								return new ModelAndView("VaccineLogin", "succesregistrationmessage",
										"Password Succesfully changed");
							} else {
								return new ModelAndView("Reset", "messagefromLoginController", "Not updated ...");
							}

						}

						return new ModelAndView("Reset", "messagefromLoginController", "Not updated");

					} else {
						return new ModelAndView("Reset", "messagefromLoginController", "Incorrect email!!!");
					}

				} else {
					return new ModelAndView("Reset", "messagefromLoginController",
							"Password and Confirm Password are not matching");

				}

			} else if (resetDTO.getEmail().isEmpty()) {
				return new ModelAndView("Reset", "messageinfo", map.get("email"));

			} else if (resetDTO.getPassword().isEmpty()) {
				return new ModelAndView("Reset", "messageinfopassword", map.get("password"));

			} else if (resetDTO.getConfirmPassword().isEmpty()) {
				return new ModelAndView("Reset", "messageinfoconfirmpassword", map.get("confirmPassword"));

			}

		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ControllerException("Exception occouring in Login Controller" + e.getMessage());
		}
		return null;

	}

}
