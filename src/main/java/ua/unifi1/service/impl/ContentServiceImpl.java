package ua.unifi1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.unifi1.domain.ContentDTO;
import ua.unifi1.entity.ContentEntity;
import ua.unifi1.exception.ResourseNotFoundException;
import ua.unifi1.repository.ContentRepository;
import ua.unifi1.service.ContentService;
import ua.unifi1.utils.ObjectMapperUtils;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository contentRepository;
	
	@Autowired
	private ObjectMapperUtils contentMapper;
	
	@Override
	public void saveContent(ContentDTO dto) {
		ContentEntity entity = contentMapper.map(dto, ContentEntity.class);
		contentRepository.save(entity);
	}

	@Override
	public ContentDTO findById(Long id) {
		ContentEntity entity = contentRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Record with id[" + id + "] not found")
				);
		ContentDTO dto = contentMapper.map(entity, ContentDTO.class);
		return dto;
	}

	@Override
	public List<ContentDTO> findAllContent() {
		List<ContentEntity> entities = contentRepository.findAll();
		List<ContentDTO> dtos = contentMapper.mapAll(entities, ContentDTO.class);
		return dtos;
	}

}
