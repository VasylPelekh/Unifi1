package ua.unifi1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "education")
public class EducationEntity extends BaseEntity{
	
	@Column(nullable = false, name = "Name_Institution")
	private String nameInstitution;
	
	@Column(nullable = false, name = "Special")
	private String special;
	
	@Column(nullable = false, name = "Begin")
	private int begin;
	
	@Column(nullable = false, name = "Finish")
	private int finish;
}
