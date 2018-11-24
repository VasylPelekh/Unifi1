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
@Table(name = "article")
public class ArticleEntity extends BaseEntity {

	@Column(nullable = true, name = "My")
	private String my;
	
	@Column(nullable = true, name = "Friends")
	private String friends;
	
	@Column(nullable = true, name = "Popular")
	private String popular;
}
