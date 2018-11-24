package ua.unifi1.service.impl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.unifi1.domain.AdressDTO;
import ua.unifi1.domain.ProfileDTO;
import ua.unifi1.entity.AdressEntity;
import ua.unifi1.entity.Profile;
import ua.unifi1.exception.ResourseNotFoundException;
import ua.unifi1.repository.AdressRepository;
import ua.unifi1.service.AdressService;
import ua.unifi1.utils.ObjectMapperUtils;

@Service
public class AdressServiceImpl implements AdressService {

	@Autowired
	private AdressRepository adressRepository;

	@Autowired
	private ObjectMapperUtils adressMapper;
	
	@Override
	public void saveAdress(AdressDTO dto) {
		AdressEntity entity = adressMapper.map(dto, AdressEntity.class);
		adressRepository.save(entity);
	}

	@Override
	public AdressDTO findById(Long id) {
		AdressEntity entity = adressRepository
				.findById(id).orElseThrow(
						() -> new ResourseNotFoundException("Record with id[" + id + "] not found")
						);
		AdressDTO dto = adressMapper.map(entity, AdressDTO.class);
		return dto;
	}

	@Override
	public List<AdressDTO> findAllAdress() {
		List<AdressEntity> entities = adressRepository.findAll();
		List<AdressDTO> dtos = adressMapper.mapAll(entities, AdressDTO.class);
		return dtos;
	}
	
	
	

}
