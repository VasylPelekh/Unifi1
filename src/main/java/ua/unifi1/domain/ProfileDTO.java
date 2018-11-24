package ua.unifi1.domain;

import lombok.Data;
import ua.unifi1.entity.SexType;

@Data
public class ProfileDTO {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String surName;
	
	private int age;
	
	private SexType sex;
	
	private AdressDTO adress;
	
	private EducationDTO education;
	
	private FamilyDTO family;
	
	private String pfoto;
	
	private String email;
	
	private String phoneNumber;
}
