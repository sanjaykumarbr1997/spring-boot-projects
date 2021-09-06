package com.xworkz.vaccination.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.xworkz.vaccination.dto.MemberDetailsDTO;
import com.xworkz.vaccination.exceptions.DaoException;
import com.xworkz.vaccination.exceptions.ServiceException;
import com.xworkz.vaccination.service.MemberRegistrationService;
import com.xworkz.vaccination.service.MemberRegistrationServiceImpl;

@Controller
public class UpdateMemberDetailsController {
	private static final Logger logger=Logger.getLogger(UpdateMemberDetailsController.class);
	
	public UpdateMemberDetailsController() {
		logger.debug(this.getClass().getSimpleName()+" object created");
	}


	Map<String, String> mapping = MemberRegistrationServiceImpl.mapping;
	@Autowired
	MemberRegistrationService memberService;

	@GetMapping("/listall.all")
	public ModelAndView listAllData() throws ServiceException {
		logger.info("Invoked listAllData()");
		return new ModelAndView("MemberList", "listOfMembers", this.memberService.getAllDetails());
	}

	@GetMapping("/memberedit/{id}.all")
	public ModelAndView getMemberDetails(@PathVariable int id) throws ServiceException {
		logger.info("Invoked getMemberDetails()");

		return new ModelAndView("MemberListEdit", "update", memberService.getDetailsById(id));

	}

	@PostMapping("/memberedit/membersUpdate/{aadhar}.all")
	public ModelAndView updateDetailsByAadhar(@ModelAttribute MemberDetailsDTO memberDto, @PathVariable String aadhar) throws ServiceException, DaoException {
		logger.info("Invoked updateDetailsByAadhar()");

		boolean validateDTO = memberService.validate(memberDto);
		if (validateDTO) {
			memberService.updateDetailsByAadhar(aadhar, memberDto);
			return new ModelAndView("redirect:/listall.all");
		} else if (memberDto.getNameOfMember().isEmpty()) {
			return new ModelAndView("MemberListEdit", "messageenrollname", mapping.get("name"));

		} else if (memberDto.getGenderOfMember() == null) {
			return new ModelAndView("MemberListEdit", "messageenrollgender", mapping.get("gender"));

		} else if (memberDto.getAadharOfMember().isEmpty()) {
			return new ModelAndView("MemberListEdit", "messageenrollaadhar", mapping.get("aadhar"));

		} else if (memberDto.getMobileNoOfMember().isEmpty()) {
			return new ModelAndView("MemberListEdit", "messageenrollmobile", mapping.get("mobile"));

		} else if (memberDto.getTypeOfVaccine().isEmpty()) {
			return new ModelAndView("MemberListEdit", "messageenrolltype", mapping.get("type"));

		}
		return new ModelAndView("MemberListEdit", "messageenrolltype", "details not updated!!!");

	}

}
