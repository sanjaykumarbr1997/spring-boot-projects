package com.xworkz.vaccination.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "verify", query = "select entity from VaccinationEntity entity where entity.email=:emailid "),
		@NamedQuery(name = "verifyEmail", query = "select entity.email from VaccinationEntity entity where entity.email=:emailID "),
		@NamedQuery(name = "updateNoOfLoginAttempByEmail", query = "update VaccinationEntity entity set entity.noOfLoginAttempts=:login where entity.email=:emailId"),
		@NamedQuery(name = "getUnsuccessfulAttempt", query = "select entity.noOfLoginAttempts from VaccinationEntity entity  where entity.email=:email"),
		@NamedQuery(name = "updatePassword", query = "update VaccinationEntity entity set entity.password=:passw where entity.email=:emailAddress"),
		@NamedQuery(name = "updateUnsucessfulLoginAttempt", query = "update VaccinationEntity entity set entity.noOfLoginAttempts=:loginAttempt where entity.email=:emailAddress"),
		@NamedQuery(name = "updateNoOfMembersRegistered", query = "update VaccinationEntity entity set entity.noOfMembersRegistered=:membersRegistered where entity.email=:emailAdr"),
		@NamedQuery(name = "getMembersRegistered", query = "select entity.noOfMembersRegistered from VaccinationEntity entity  where entity.email=:email")

})

@Table(name = "enroll_details_for_vaccination")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class VaccinationEntity implements Serializable {
	@Id
	@Column(name = "ENROLL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "ENROLL_NAME")
	private String name;
	@Column(name = "ENROLL_EMAIL")
	private String email;
	@Column(name = "ENROLL_PASSWORD")
	private String password;
	@Column(name = "ENROLL_MOBILE_NO")
	private String mobileNo;
	@Column(name = "TYPE_OF_VACCINE")
	private String typeOfVaccine;
	@Column(name = "ENROLL_GENDER")
	private String gender;
	@Column(name = "ENROLL_NO_OF_LOGIN_ATTEMPTS")
	private int noOfLoginAttempts;
	@Column(name = "NO_OF_MEMBERS_REGISTERED")
	private int noOfMembersRegistered;
}
