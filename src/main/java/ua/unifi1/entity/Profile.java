package ua.unifi1.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.unifi1.entity.SexType;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "profile")
public class Profile extends BaseEntity{

	/*
	
	{
	"firstName" : "Vasyl",
	"lastName" : "Pelekh",
	"surName" : "Oleksiovuch",
	"age" : 25,
	"sex" : "MALE",
	"adress" : {"id" : 1},
	"education" : {"id" : 1},
	"pfoto" : "http://egasdev",
	"email" : "Pelekh.o.v@gmail.com",
	"phoneNumber" : "+380634433333"	
}
	*/
	@Column(nullable = false, name = "firstName")
	private String firstName;
	
	@Column(nullable = false, name = "lastName")
	private String lastName;
	
	@Column(nullable = false, name = "surName")
	private String surName;
	
	@Column(nullable = false, name = "age")
	private int age;
	
	@Enumerated(EnumType.STRING)
	private SexType sex;
	
	@ManyToOne
	@JoinColumn(name = "adress_id")
	private AdressEntity adress;
	
	@ManyToOne
	@JoinColumn(name = "education_id")
	private EducationEntity education;
		
	@ManyToOne
	@JoinColumn(name = "message_id")
	private MessageEntity messageEntity;
	
	@Column(nullable = true)
	private String pfoto;
	
	@Column(nullable = false, name = "email")
	private String email;
	
	@Column(nullable = false, name = "phoneNumber")
	private String phoneNumber;
}
