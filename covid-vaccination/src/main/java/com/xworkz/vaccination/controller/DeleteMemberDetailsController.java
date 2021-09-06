package com.xworkz.vaccination.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xworkz.vaccination.exceptions.ServiceException;
import com.xworkz.vaccination.service.MemberRegistrationService;

@Controller
public class DeleteMemberDetailsController {
	private static final Logger logger=Logger.getLogger(DeleteMemberDetailsController.class);
	
	public DeleteMemberDetailsController() {
		logger.debug(this.getClass().getSimpleName()+"object created");
	}

	@Autowired
	MemberRegistrationService memberService;

	@GetMapping("/memberdelete/{aadhar}.all")
	public String deleteDetailsByAadhar(@PathVariable String aadhar) throws ServiceException {
		logger.info("Invoked deleteDetailsByAadhar()");
		memberService.deleteDetailsByAadhar(aadhar);
		return "redirect:/listall.all";

	}

}
