package ua.unifi1.service;

import java.util.List;

import ua.unifi1.domain.ArticleDTO;

public interface ArticleService {

	void saveArticle (ArticleDTO dto);
	
	ArticleDTO findById(Long id);
	
	List<ArticleDTO> findAllArticle();
}
