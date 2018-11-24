package ua.unifi1.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


@Entity
@Table(name = "content")
public class ContentEntity extends BaseEntity {
	
	
	private String content;
	
	
}
