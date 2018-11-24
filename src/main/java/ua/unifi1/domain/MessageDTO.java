package ua.unifi1.domain;

import java.time.LocalTime;


import lombok.Data;
import ua.unifi1.entity.ContentEntity;
import ua.unifi1.entity.Profile;

@Data
public class MessageDTO {

private Profile toId;
	
	private Profile fromID;
	
	private ContentEntity contentEntity;
	
	private LocalTime createdAt;
	
	private LocalTime updatetAt;
}
