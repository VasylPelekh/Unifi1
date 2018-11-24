package ua.unifi1.service;

import java.util.List;

import ua.unifi1.domain.AdressDTO;
import ua.unifi1.domain.EducationDTO;
import ua.unifi1.domain.FamilyDTO;
import ua.unifi1.domain.ProfileDTO;
import ua.unifi1.entity.AdressEntity;
import ua.unifi1.entity.SexType;

public interface ProfileService {

	void saveProfile (ProfileDTO dto);
	ProfileDTO findById(Long id);
	List<ProfileDTO> findAllProfile();
	List<ProfileDTO> findAllProfileByFirstName(String firstName);
	List<ProfileDTO> findAllProfileByLastName(String lastName);
	List<ProfileDTO> findAllProfileByAge(Integer age);
	List<ProfileDTO> findAllProfileBySexType(SexType sex);
	List<ProfileDTO> findAllByEducationId(Long id);
	List<ProfileDTO> findAllByAdressId(Long id);
	
	void addPfotoToProfile(Long id, String fileName);
}
