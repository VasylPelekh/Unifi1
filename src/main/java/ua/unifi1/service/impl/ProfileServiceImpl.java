package ua.unifi1.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.unifi1.domain.AdressDTO;
import ua.unifi1.domain.EducationDTO;
import ua.unifi1.domain.FamilyDTO;
import ua.unifi1.domain.ProfileDTO;
import ua.unifi1.entity.Profile;
import ua.unifi1.entity.SexType;
import ua.unifi1.exception.AlreadyExistsException;
import ua.unifi1.exception.ResourseNotFoundException;
import ua.unifi1.repository.ProfileRepository;
import ua.unifi1.service.ProfileService;
import ua.unifi1.utils.ObjectMapperUtils;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ObjectMapperUtils profileMapper;
	
	@Override
	public void saveProfile(ProfileDTO dto) {
		Profile checkExsistsEmail = 
				profileRepository.findByProfileEmail(dto.getEmail());	
		if(checkExsistsEmail != null) {
			throw new AlreadyExistsException("Record with email["+dto.getEmail()+"] already exists");
		}
		
		Profile checkExistsPhoneNumber = 
				profileRepository.findByProfilePhone(dto.getPhoneNumber());		
		if(checkExistsPhoneNumber != null) {
			throw new AlreadyExistsException("Record with phoneNumber["+dto.getPhoneNumber()+"] already exists");
		}
		
		
		Profile entity = profileMapper.map(dto, Profile.class);
		profileRepository.save(entity);
		
	}

	@Override
	public ProfileDTO findById(Long id) {
		Profile entity = profileRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Record with id[" + id + "] not found")
				);
		ProfileDTO dto = profileMapper.map(entity, ProfileDTO.class);
		return dto;
	}

	@Override
	public List<ProfileDTO> findAllProfile() {
		List<Profile> entities = profileRepository.findAll();
		List<ProfileDTO> dtos = profileMapper.mapAll(entities, ProfileDTO.class);
		return dtos;
	}

	@Override
	public List<ProfileDTO> findAllProfileByFirstName(String firstName) {
		List<Profile> entities = profileRepository.findAllProfileByFirstName(firstName);
		List<ProfileDTO> dtos = profileMapper.mapAll(entities, ProfileDTO.class);
		return dtos;
	}

	@Override
	public List<ProfileDTO> findAllProfileByLastName(String lastName) {
		List<Profile> entities = profileRepository.findAllProfileByLastName(lastName);
		List<ProfileDTO> dtos = profileMapper.mapAll(entities, ProfileDTO.class);
		return dtos;
	}

	@Override
	public List<ProfileDTO> findAllProfileByAge(Integer age) {
		List<Profile> entities = profileRepository.findAllProfileByAge(age);
		List<ProfileDTO> dtos = profileMapper.mapAll(entities, ProfileDTO.class);
		return dtos;
	}

	@Override
	public List<ProfileDTO> findAllProfileBySexType(SexType sex) {
		List<Profile> entities = profileRepository.findAllProfileBySexType(sex);
		List<ProfileDTO> dtos = profileMapper.mapAll(entities, ProfileDTO.class);
		return dtos;
	}

	@Override
	public List<ProfileDTO> findAllByAdressId(Long id) {
			return profileMapper.mapAll(profileRepository.findByAdressId(id), ProfileDTO.class);
	}

	@Override
	public List<ProfileDTO> findAllByEducationId(Long id) {
			return profileMapper.mapAll(profileRepository.findByEducationId(id), ProfileDTO.class);
	}
	

	@Override
	public void addPfotoToProfile(Long id, String fileName) {

		Profile profile = profileRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Record with id[" + id + "] not found")
				);
		profile.setPfoto(fileName);
		profileRepository.save(profile);
	}
	
	

}
