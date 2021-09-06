package com.xworkz.vaccination.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.xworkz.vaccination.exceptions.ControllerException;
import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;
import com.xworkz.vaccination.service.OtpService;
import com.xworkz.vaccination.service.VaccinationLoginService;
import com.xworkz.vaccination.service.VaccinationLoginServiceImpl;

@Controller
@RequestMapping("/")
public class VaccinationLoginController {

	Map<String, String> map = VaccinationLoginServiceImpl.map;
	private static final Logger logger=Logger.getLogger(VaccinationLoginController.class.getSimpleName());
	

	public VaccinationLoginController() {
		
		logger.debug(this.getClass().getSimpleName()+" object created");
	

	}

	@Autowired
	private VaccinationLoginService vaccinationLoginService;

	@Autowired
	private OtpService otpService;
	
	@RequestMapping("/displaylogin")
	public String displayLoginPage() {
		return "VaccineLogin";
	}

	@PostMapping("/login.all")
	public ModelAndView verifyLoginDetails(@RequestParam String email, @RequestParam String password)
			throws ControllerException, DaoException, ServiceException {
		logger.info("invoked verifyLoginDetails()");
		boolean validateDetails;
		boolean passwordDetailsFromDB;
		boolean verifyEmailInDB;
		boolean unsuccesfulAttempCheck;

		try {

			validateDetails = vaccinationLoginService.validateLogInDetails(email, password);
			if (validateDetails) {

				verifyEmailInDB = this.otpService.verifyEmailfromDB(email);
				if (verifyEmailInDB) {
					unsuccesfulAttempCheck = vaccinationLoginService.checkUnsuccessfulAttempts(email);
					if (unsuccesfulAttempCheck) {
						passwordDetailsFromDB = this.vaccinationLoginService.getLogInDetails(email, password);
						if (passwordDetailsFromDB) {
							return new ModelAndView("VaccineHome", "username", VaccinationLoginServiceImpl.userName);

						} else {
							return new ModelAndView("VaccineLogin", "messagefromLoginController",
									map.get("errorverification"));

						}

					} else {
						return new ModelAndView("VaccineLogin", "messagefromLoginController",
								"Exceeded 3 attempts to login.You are blocked!!!");
					}

				} else {
					return new ModelAndView("VaccineLogin", "messagefromLoginController", "Incorrect email!!!");
				}

			} else if (email.isEmpty()) {
				return new ModelAndView("VaccineLogin", "messageinfo", map.get("email"));

			} else if (password.isEmpty()) {
				return new ModelAndView("VaccineLogin", "messageinfopassword", map.get("password"));

			}

		} catch (ServiceException e) {
			e.printStackTrace();
			throw new ControllerException("Exception occouring in Login Controller" + e.getMessage());
		}
		return null;

	}

}
