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

import ua.unifi1.domain.FamilyDTO;
import ua.unifi1.service.FamilyService;

@RestController
@RequestMapping("family")
public class FamilyController {

	@Autowired
	private FamilyService familyService;
	
	@PostMapping("/add")
	public ResponseEntity<Void> addFamily(@RequestBody FamilyDTO dto){
		familyService.saveFamily(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getFamilys(){
		List<FamilyDTO> dto = familyService.findAllFamily();
		return new ResponseEntity<List<FamilyDTO>>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{familyId}")
	public ResponseEntity<?> getAdress(@PathVariable("familyId") Long id){
		FamilyDTO dto = familyService.findById(id);
		return new ResponseEntity<FamilyDTO>(dto, HttpStatus.OK);

	}
	
	@GetMapping("profile/{profileId}")
	public ResponseEntity<?> getFamiliesByProfile(@PathVariable("profileId") Long id) {
		return new ResponseEntity<>(familyService.findAllByProfileId(id), HttpStatus.OK);
	}
}
