package ua.unifi1.domain;

import lombok.Data;

@Data
public class EducationDTO {

	private Long id;

	private String nameInstitution;

	private String special;

	private int begin;

	private int finish;

}
