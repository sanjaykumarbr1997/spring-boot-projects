package com.xworkz.vaccination.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.vaccination.dto.MemberDetailsDTO;
import com.xworkz.vaccination.entity.MemberDetailsEntity;
import com.xworkz.vaccination.exceptions.ControllerException;
import com.xworkz.vaccination.service.MemberRegistrationService;
import com.xworkz.vaccination.service.MemberRegistrationServiceImpl;

@Controller
public class MemberRegistrationController {
	Map<String, String> mapping = MemberRegistrationServiceImpl.mapping;
	private static final Logger logger=Logger.getLogger(MemberRegistrationController.class);

	
	public MemberRegistrationController() {
		logger.debug(this.getClass().getSimpleName()+" object created");
	}

	@Autowired
	private MemberRegistrationService memberService;

	@RequestMapping("/addmemberdetails.all")
	public String onAddMemberClicked() {
		logger.info("Invoked onAddMemberClicked()");


		return "MemberRegistration";
	}

	@PostMapping("/savememberdetails.all")
	public ModelAndView onAddMemberClicked(@ModelAttribute MemberDetailsDTO memberDTO) throws ControllerException {
		logger.info("Invoked onAddMemberClicked()");

		boolean validationDetails;
		boolean detailsSaved;
		boolean noOfMembersRegistered;

		try {

			noOfMembersRegistered = this.memberService.checkNoOfMembersRegistered();
			validationDetails = this.memberService.validate(memberDTO);
			System.out.println("validation outcome" + validationDetails);

			if (noOfMembersRegistered) {
				if (validationDetails) {
					detailsSaved = this.memberService.saveMemberDetailsDTO(memberDTO);
					if (detailsSaved) {
						return new ModelAndView("MemberList", "listOfMembers", this.memberService.getAllDetails());
					} else {
						return new ModelAndView("MemberRegistration", "messagetodisplay",
								"Details not saved..try again");

					}

				} else if (memberDTO.getNameOfMember().isEmpty()) {
					return new ModelAndView("MemberRegistration", "messageenrollname", mapping.get("name"));

				} else if (memberDTO.getGenderOfMember() == null) {
					return new ModelAndView("MemberRegistration", "messageenrollgender", mapping.get("gender"));

				} else if (memberDTO.getAadharOfMember().isEmpty()) {
					return new ModelAndView("MemberRegistration", "messageenrollaadhar", mapping.get("aadhar"));

				} else if (memberDTO.getMobileNoOfMember().isEmpty()) {
					return new ModelAndView("MemberRegistration", "messageenrollmobile", mapping.get("mobile"));

				} else if (memberDTO.getTypeOfVaccine().isEmpty()) {
					return new ModelAndView("MemberRegistration", "messageenrolltype", mapping.get("type"));

				}

			} else {
				return new ModelAndView("MemberRegistration", "message", "Sorry only 4 members can be registered...");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ControllerException(e.getMessage());

		}
		return null;

	}

}
