package ua.unifi1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.unifi1.domain.ArticleDTO;
import ua.unifi1.service.ArticleService;

@RestController
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@PostMapping("/add")
	public ResponseEntity<Void> addArticle(@RequestBody ArticleDTO dto){
		articleService.saveArticle(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getArticles(){
		List<ArticleDTO> dto = articleService.findAllArticle();
		return new ResponseEntity<List<ArticleDTO>>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{articleId}")
	public ResponseEntity<?> getArticle(@PathVariable("articleId") Long id){
		ArticleDTO dto = articleService.findById(id);
		return new ResponseEntity<ArticleDTO>(dto, HttpStatus.OK);

	}
	
	
}
