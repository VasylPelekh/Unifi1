package ua.unifi1.domain;


import lombok.Data;

@Data
public class AdressDTO {

	private Long id;

	private String country;

	private String region;

	private String district;

	private String city;

	private String village;

}
