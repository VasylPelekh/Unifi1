package ua.unifi1.service;

import java.util.List;

import ua.unifi1.domain.EducationDTO;


public interface EducationService {

	void saveEducation (EducationDTO dto);

	EducationDTO findById(Long id);

	List<EducationDTO> findAllEducation();
}
