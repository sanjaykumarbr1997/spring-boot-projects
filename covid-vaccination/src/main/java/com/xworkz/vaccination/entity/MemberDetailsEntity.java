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

import lombok.Data;

@Entity
@Table(name = "member_details_of_vaccinated")
@NamedQueries(value = { @NamedQuery(name = "fetchAllDetails", query = " from MemberDetailsEntity entity "),
		@NamedQuery(name = "updateDetailsByAadhar", query = "update MemberDetailsEntity entity set entity.nameOfMember=:name,entity.genderOfMember=:gender,entity.aadharOfMember=:aadhar,entity.mobileNoOfMember=:mobile,entity.typeOfVaccine =:type where entity.aadharOfMember=:aadharno"),
		@NamedQuery(name = "deleteDetialsByAadhar", query = "delete from MemberDetailsEntity entity where entity.aadharOfMember=:aadharNumber") })
@Data
public class MemberDetailsEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID")
	private int id;
	@Column(name = "MEMBER_NAME")
	private String nameOfMember;
	@Column(name = "MEMBER_GENDER")
	private String genderOfMember;
	@Column(name = "MEMBER_AADHAR")
	private String aadharOfMember;
	@Column(name = "MEMBER_MOBILE_NUMBER")
	private String mobileNoOfMember;
	@Column(name = "MEMBER_VACCINATED_BY")
	private String typeOfVaccine;

}
