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

import ua.unifi1.domain.ContentDTO;
import ua.unifi1.service.ContentService;


@RestController
@RequestMapping("content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@PostMapping("/add")
	public ResponseEntity<Void> addContent(@RequestBody ContentDTO dto){
		contentService.saveContent(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getContents(){
		List<ContentDTO> dto = contentService.findAllContent();
		return new ResponseEntity<List<ContentDTO>>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{contentId}")
	public ResponseEntity<?> getContent(@PathVariable("contentId") Long id){
		ContentDTO dto = contentService.findById(id);
		return new ResponseEntity<ContentDTO>(dto, HttpStatus.OK);

	}
}
