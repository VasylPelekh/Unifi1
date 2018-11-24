package ua.unifi1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.unifi1.domain.EducationDTO;
import ua.unifi1.entity.EducationEntity;
import ua.unifi1.entity.Profile;
import ua.unifi1.exception.ResourseNotFoundException;
import ua.unifi1.repository.EducationRepository;
import ua.unifi1.service.EducationService;
import ua.unifi1.utils.ObjectMapperUtils;

@Service
public class EducationServiceImpl implements EducationService{

	@Autowired
	private EducationRepository educationRepository;

	@Autowired
	private ObjectMapperUtils educationMapper;
	
	@Override
	public void saveEducation(EducationDTO dto) {
		EducationEntity entity = educationMapper.map(dto, EducationEntity.class);
		educationRepository.save(entity);
	}

	@Override
	public EducationDTO findById(Long id) {
		EducationEntity entity = educationRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Record with id[" + id + "] not found")
				);
		EducationDTO dto = educationMapper.map(entity, EducationDTO.class);
		return dto;
	}

	@Override
	public List<EducationDTO> findAllEducation() {
		List<EducationEntity> entities = educationRepository.findAll();
		List<EducationDTO> dtos = educationMapper.mapAll(entities, EducationDTO.class);
		return dtos;
	}
	
	

}
