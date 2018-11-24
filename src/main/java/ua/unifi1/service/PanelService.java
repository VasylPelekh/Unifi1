package ua.unifi1.service;

import java.util.List;

import ua.unifi1.domain.FamilyDTO;
import ua.unifi1.domain.PanelDTO;


public interface PanelService {

	void savePanel (PanelDTO dto);

	PanelDTO findById(Long id);

	List<PanelDTO> findAllPanel();
	
	List<PanelDTO> findAllByProfileId(Long id);
	
	void addFileToPanel(Long id, String fileName);
	
	
}
