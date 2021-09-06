package com.xworkz.vaccination.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.vaccination.exceptions.ControllerException;
import com.xworkz.vaccination.service.OtpService;
import com.xworkz.vaccination.service.OtpServiceImpl;
import com.xworkz.vaccination.util.EmailValidatorUtil;

@Controller
@RequestMapping("/")
public class OTPController {
	private static final Logger logger=Logger.getLogger(OTPController.class);


	Map<String, String> map = OtpServiceImpl.map;

	public OTPController() {
		logger.debug(this.getClass().getSimpleName()+" object created");

	}

	@Autowired
	private OtpService otpService;

	@GetMapping("/getloginpage.all")
	public String getLoginPage() {
		logger.info("getLoginPage()");
		return "Welcome";

	}

	@PostMapping("/otpgenerator.all")
	public ModelAndView generateAOTP(@RequestParam String email) throws ControllerException {
		boolean otpDetails;
		boolean emailFromDBCheck;
		try {
			otpDetails = otpService.validateEmail(email);
			if (otpDetails) {
				System.out.println("validation of email is done");

				boolean validateEmail = EmailValidatorUtil.isValidEmailAddress(email);

				if (validateEmail) {

					emailFromDBCheck = this.otpService.verifyEmailfromDB(email);
					if (emailFromDBCheck) {

						System.out.println("email from db:" + emailFromDBCheck);
						return new ModelAndView("Welcome", "message", "Email id already exists");

					} else {
						this.otpService.generateOTP(email);
						return new ModelAndView("VaccineOTPVerification", "welocmeotpmessage", "In Verification page");

					}

				} else {

					return new ModelAndView("Welcome", "message", "Invalid Email!!!!!");

				}
			} else {

				return new ModelAndView("Welcome", "message", map.get("email"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ControllerException(e.getMessage());

		}

	}

	@PostMapping("/verify.all")
	public ModelAndView verifyOTPDetails(@RequestParam String otp) throws ControllerException {
		logger.info("invoked verifyOTPDetails()");
		boolean validateCheck;
		boolean verifyCheck;
		try {
			validateCheck = otpService.validateOTP(otp);
			if (validateCheck) {
				verifyCheck = this.otpService.verifyOTP(otp);
				if (verifyCheck) {
					return new ModelAndView("VaccineEnroll", "messagesuccess", "OTP verified .Thank you!!!");
				} else {
					return new ModelAndView("VaccineOTPVerification", "otpmessage", map.get("otpverify"));

				}

			} else {
				return new ModelAndView("VaccineOTPVerification", "otpmessage", map.get("otpvalidate"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ControllerException(e.getMessage());

		}

	}

}
