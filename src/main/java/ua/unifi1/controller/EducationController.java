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

import ua.unifi1.domain.EducationDTO;
import ua.unifi1.entity.EducationEntity;
import ua.unifi1.service.EducationService;

@RestController
@RequestMapping("education")
public class EducationController {

	@Autowired
	private EducationService educationService;
	
	@PostMapping("/add")
	public ResponseEntity<Void> addEducation(@RequestBody EducationDTO dto){
		educationService.saveEducation(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getEducations(){
		List<EducationDTO> dtos = educationService.findAllEducation();
		return new ResponseEntity<List<EducationDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/{educationId}")
	public ResponseEntity<?> getEducation(@PathVariable("educationId") Long id){
		EducationDTO dto = educationService.findById(id);
		return new ResponseEntity<EducationDTO>(dto, HttpStatus.OK);

	}	
}
