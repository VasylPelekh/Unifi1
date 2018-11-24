package ua.unifi1.service;

import java.util.List;

import ua.unifi1.domain.FamilyDTO;
import ua.unifi1.domain.PanelDTO;
import ua.unifi1.entity.FielsType;


public interface PanelService {

	void savePanel (PanelDTO dto);

	void addFileToPanel(Long id, String fileName);
	
	PanelDTO findById(Long id);

	List<PanelDTO> findAllPanel();
	
	List<PanelDTO> findAllByProfileId(Long id);
	
	List<PanelDTO> findAllByFielsType(FielsType fielsType);
	
	
	
	
}
