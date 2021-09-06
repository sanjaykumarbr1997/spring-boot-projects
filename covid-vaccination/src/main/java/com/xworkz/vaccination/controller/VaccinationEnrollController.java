package com.xworkz.vaccination.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.vaccination.dto.VaccinationDTO;
import com.xworkz.vaccination.exceptions.ControllerException;
import com.xworkz.vaccination.service.VaccinationEnrollService;
import com.xworkz.vaccination.service.VaccinationEnrollServiceImpl;

@Controller
@RequestMapping("/")
public class VaccinationEnrollController {
	private static final Logger logger=Logger.getLogger(VaccinationEnrollController.class);


	Map<String, String> map = VaccinationEnrollServiceImpl.map;

	public VaccinationEnrollController() {
		logger.debug(this.getClass().getSimpleName() + "created");
	}

	@Autowired
	private VaccinationEnrollService enrollService;

	@PostMapping("/signin.all")
	public ModelAndView saveEnrollDetails(@ModelAttribute VaccinationDTO vaccinationDTO) throws ControllerException {
		logger.info("Invoked saveEnrollDetails()");
		boolean validationOutcome;

		try {
			validationOutcome = this.enrollService.validate(vaccinationDTO);
			System.out.println("validation outcome" + validationOutcome);

			if (validationOutcome) {
				this.enrollService.saveDTO(vaccinationDTO);
				return new ModelAndView("VaccineLogin", "succesregistrationmessage",
						"Registration Success ....Please Login To Continue!!");

			} else if (vaccinationDTO.getName().isEmpty()) {
				return new ModelAndView("VaccineEnroll", "messageenrollname", map.get("name"));

			} else if (vaccinationDTO.getEmail().isEmpty()) {
				return new ModelAndView("VaccineEnroll", "messageenrollemail", map.get("email"));

			} else if (vaccinationDTO.getPassword().isEmpty()) {
				return new ModelAndView("VaccineEnroll", "messageenrollpassword", map.get("password"));

			} else if (vaccinationDTO.getMobileNo().isEmpty()) {
				return new ModelAndView("VaccineEnroll", "messageenrollmobile", map.get("mobile"));

			} else if (vaccinationDTO.getGender() == null) {
				return new ModelAndView("VaccineEnroll", "messageenrollgender", map.get("gender"));

			} else if (vaccinationDTO.getTypeOfVaccine().isEmpty()) {
				return new ModelAndView("VaccineEnroll", "messageenrolltype", map.get("type"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ControllerException(e.getMessage());

		}
		return null;

	}

}
