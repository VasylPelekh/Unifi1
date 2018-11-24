package ua.unifi1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ua.unifi1.domain.AdressDTO;
import ua.unifi1.domain.EducationDTO;
import ua.unifi1.domain.ProfileDTO;
import ua.unifi1.entity.AdressEntity;
import ua.unifi1.entity.Profile;
import ua.unifi1.entity.SexType;
import ua.unifi1.service.FileStorageService;
import ua.unifi1.service.ProfileService;

@RestController
@RequestMapping("profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping("/add") // localhost:8080/profile
	public ResponseEntity<Void> addProfil(@RequestBody ProfileDTO dto){
		profileService.saveProfile(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getProfiles(){
		List<ProfileDTO> dtos = profileService.findAllProfile();
		return new ResponseEntity<List<ProfileDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/{profileId}")
	public ResponseEntity<?> getProfilById(@PathVariable("profileId") Long id){
		ProfileDTO dto = profileService.findById(id);
		return new ResponseEntity<ProfileDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/firstName/{profileFirstName}")
	public ResponseEntity<?> getProfileByFirstName(@PathVariable("profileFirstName") String firstName){
		List<ProfileDTO> dtos = profileService.findAllProfileByFirstName(firstName);
		return new ResponseEntity<List<ProfileDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/lastName/{profileLastName}")
	public ResponseEntity<?> getProfileByLastName(@PathVariable("profileLastName") String lastName){
		List<ProfileDTO> dtos = profileService.findAllProfileByLastName(lastName);
		return new ResponseEntity<List<ProfileDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/age/{profileAge}")
	public ResponseEntity<?> getProfileByAge(@PathVariable("profileAge") Integer age){
		List<ProfileDTO> dtos = profileService.findAllProfileByAge(age);
		return new ResponseEntity<List<ProfileDTO>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping("/sexType/{profileSexType}")
	public ResponseEntity<?> getProfileBySexType(@PathVariable("profileSexType") SexType sex){
		List<ProfileDTO> dtos = profileService.findAllProfileBySexType(sex);
		return new ResponseEntity<List<ProfileDTO>>(dtos, HttpStatus.OK);
	}
		
	@GetMapping("adress/{adressId}")
	public ResponseEntity<?> getProfileByAdress(@PathVariable("adressId") Long id) {
		return new ResponseEntity<>(profileService.findAllByAdressId(id), HttpStatus.OK);
	}
	
	@GetMapping("education/{educationId}")
	public ResponseEntity<?> getProfileByEducation(@PathVariable("educationId") Long id) {
		return new ResponseEntity<>(profileService.findAllByEducationId(id), HttpStatus.OK);
	}
	
	
	@PostMapping("{profileId}/file")
	public ResponseEntity<Void> uploadFile(
			@PathVariable("profileId") Long id,
			@RequestParam("file") MultipartFile file  ){
		
		System.out.println(file.getOriginalFilename());
		String fileName = fileStorageService.storeFile(file);
		profileService.addPfotoToProfile(id, fileName);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("file/{fileName}")
	public ResponseEntity<Resource> getFile(
			@PathVariable("fileName") String fileName,
			HttpServletRequest request){
		
		Resource resource = fileStorageService.loadFile(fileName);
		
		String contentType = null;
		
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline: filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
}
