package ua.unifi1.domain;


import lombok.Data;
import ua.unifi1.entity.FamilyType;

@Data
public class FamilyDTO {
	
	private Long id;

	private ProfileDTO profile;
	
	private ProfileDTO relation;
	
	private FamilyType family;
}
