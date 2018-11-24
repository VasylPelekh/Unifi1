package ua.unifi1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.unifi1.domain.FamilyDTO;
import ua.unifi1.entity.FamilyEntity;
import ua.unifi1.exception.ResourseNotFoundException;
import ua.unifi1.repository.FamilyRepository;
import ua.unifi1.service.FamilyService;
import ua.unifi1.utils.ObjectMapperUtils;


@Service
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	private FamilyRepository familyRepository;
	
	@Autowired
	private ObjectMapperUtils familyMapper;
	
	@Override
	public void saveFamily(FamilyDTO dto) {
		FamilyEntity entity = familyMapper.map(dto, FamilyEntity.class);
		familyRepository.save(entity);
	}

	@Override
	public FamilyDTO findById(Long id) {
		FamilyEntity entity = familyRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Record with id[" + id + "] not found")
				);
		FamilyDTO dto = familyMapper.map(entity, FamilyDTO.class);
		return dto;
	}

	@Override
	public List<FamilyDTO> findAllFamily() {
		List<FamilyEntity> entities = familyRepository.findAll();
		List<FamilyDTO> dtos = familyMapper.mapAll(entities, FamilyDTO.class);
		return dtos;
	}

	@Override
	public List<FamilyDTO> findAllByProfileId(Long id) {
		return familyMapper.mapAll(familyRepository.findByProfileId(id), FamilyDTO.class);
	}

}
