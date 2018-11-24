package ua.unifi1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.unifi1.domain.ArticleDTO;
import ua.unifi1.entity.ArticleEntity;
import ua.unifi1.exception.ResourseNotFoundException;
import ua.unifi1.repository.ArticleRepository;
import ua.unifi1.service.ArticleService;
import ua.unifi1.utils.ObjectMapperUtils;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ObjectMapperUtils articleMapper;
	
	@Override
	public void saveArticle(ArticleDTO dto) {
		ArticleEntity entity = articleMapper.map(dto, ArticleEntity.class);
		articleRepository.save(entity);
	}

	@Override
	public ArticleDTO findById(Long id) {
		ArticleEntity entity = articleRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Record with id[" + id + "] not found")
				);
		ArticleDTO dto = articleMapper.map(entity, ArticleDTO.class);
		return dto;
	}

	@Override
	public List<ArticleDTO> findAllArticle() {
		List<ArticleEntity> entities = articleRepository.findAll();
		List<ArticleDTO> dtos = articleMapper.mapAll(entities, ArticleDTO.class);
		return dtos;
	}

}
