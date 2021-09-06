package com.xworkz.vaccination.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class VaccinationEnrollUtil {
	private static final Logger logger = Logger.getLogger(VaccinationEnrollUtil.class);

	@Autowired
	private JavaMailSender mailSender;

	public void setProperties(String mail, String subject, String text) {
		logger.info("Invoked setProperties() from VaccinationEnrollUtil");

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(mail);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(text);

		mailSender.send(simpleMailMessage);

	}

}
