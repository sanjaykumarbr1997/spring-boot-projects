package com.xworkz.vaccination.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogOutController {
	private static final Logger logger=Logger.getLogger(LogOutController.class);

	public LogOutController() {
		logger.debug(this.getClass().getSimpleName()+"object created");
	}

	@GetMapping("/logout.all")
	public String logout(HttpServletRequest request) {
	logger.info("Invoked logout()");

		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "VaccineLogin";

	}

}
