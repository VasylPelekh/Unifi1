package ua.unifi1.service;

import java.util.List;

import ua.unifi1.domain.FamilyDTO;


public interface FamilyService {

	void saveFamily (FamilyDTO dto);

	FamilyDTO findById(Long id);

	List<FamilyDTO> findAllFamily();
	
	List<FamilyDTO> findAllByProfileId(Long id);
}
