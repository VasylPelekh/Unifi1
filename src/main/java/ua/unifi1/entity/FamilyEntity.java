package ua.unifi1.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "family")
public class FamilyEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(nullable = true, name = "profile_id")
	private Profile profile;
	
	@ManyToOne
	@JoinColumn(nullable = true, name = "relation_id")
	private Profile relation;

	
	@Enumerated(EnumType.STRING)
	private FamilyType family;
	
	
}
