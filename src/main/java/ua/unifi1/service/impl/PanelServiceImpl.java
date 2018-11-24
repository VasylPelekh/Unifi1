package ua.unifi1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.unifi1.domain.PanelDTO;
import ua.unifi1.entity.PanelEntity;
import ua.unifi1.exception.ResourseNotFoundException;
import ua.unifi1.repository.PanelRepository;
import ua.unifi1.service.PanelService;
import ua.unifi1.utils.ObjectMapperUtils;

@Service
public class PanelServiceImpl implements PanelService {

	@Autowired
	private PanelRepository panelRepository;

	@Autowired
	private ObjectMapperUtils panelMapper;

	@Override
	public void savePanel(PanelDTO dto) {
		PanelEntity entity = panelMapper.map(dto, PanelEntity.class);
		panelRepository.save(entity);
	}

	@Override
	public PanelDTO findById(Long id) {
		PanelEntity entity = panelRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Record with id[" + id + "] not found")
				);
		PanelDTO dto = panelMapper.map(entity, PanelDTO.class);
		return dto;	
	}

	@Override
	public List<PanelDTO> findAllPanel() {
		List<PanelEntity> entities = panelRepository.findAll();
		List<PanelDTO> dtos = panelMapper.mapAll(entities, PanelDTO.class);
		return dtos;
	}

	@Override
	public void addFileToPanel(Long id, String fileName) {
		PanelEntity panel = panelRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Record with id[" + id + "] not found")
				);
		panel.setFileName(fileName);
		panelRepository.save(panel);
	}
	
	@Override
	public List<PanelDTO> findAllByProfileId(Long id) {
		return panelMapper.mapAll(panelRepository.findByProfileId(id), PanelDTO.class);
	}

}
