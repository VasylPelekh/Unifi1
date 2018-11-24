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

import ua.unifi1.domain.AdressDTO;
import ua.unifi1.entity.AdressEntity;
import ua.unifi1.entity.Profile;
import ua.unifi1.service.AdressService;

@RestController
@RequestMapping("adress")
public class AdressController {

	@Autowired
	private AdressService adressService;
	
	@PostMapping("/add")
	public ResponseEntity<Void> addAdress(@RequestBody AdressDTO dto){
		adressService.saveAdress(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAdresses(){
		List<AdressDTO> dto = adressService.findAllAdress();
		return new ResponseEntity<List<AdressDTO>>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{adressId}")
	public ResponseEntity<?> getAdress(@PathVariable("adressId") Long id){
		AdressDTO dto = adressService.findById(id);
		return new ResponseEntity<AdressDTO>(dto, HttpStatus.OK);

	}
	
}
