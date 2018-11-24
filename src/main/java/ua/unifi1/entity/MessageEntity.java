package ua.unifi1.entity;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "message")
public class MessageEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "to_id")
	private Profile toId;
	
	@ManyToOne
	@JoinColumn(name = "from_id")
	private Profile fromID;
	
	@OneToOne
	@JoinColumn(name = "content_id")
	private ContentEntity contentEntity;
	
	@Column(name = "created_at")
	private LocalTime createdAt;
	
	@Column(name = "updated_at")
	private LocalTime updatetAt;
	
	
	
}
