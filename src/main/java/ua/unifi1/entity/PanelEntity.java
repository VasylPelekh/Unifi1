package ua.unifi1.entity;

import javax.persistence.Column;
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
@Table(name = "panel")
public class PanelEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(nullable = true, name = "profile_id")
	private Profile profileId;
	
	@Column(nullable = true, name = "file_name")
	private String fileName;
	
	@Enumerated(EnumType.STRING)
	private FielsType fielsType;
	
}
