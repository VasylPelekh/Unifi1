package ua.unifi1.domain;


import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import ua.unifi1.entity.ArticleEntity;
import ua.unifi1.entity.FielsType;
import ua.unifi1.entity.MessageEntity;
import ua.unifi1.entity.Profile;

@Data
public class PanelDTO {

	private ProfileDTO profile;

	private String fileName;

	private FielsType fielsType;
}
