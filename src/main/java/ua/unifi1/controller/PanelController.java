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

import ua.unifi1.domain.PanelDTO;
import ua.unifi1.service.FileStorageService;
import ua.unifi1.service.PanelService;


@RestController
@RequestMapping("panel")
public class PanelController {

	@Autowired
	private PanelService panelService;
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping("/add")
	public ResponseEntity<Void> addPanel(@RequestBody PanelDTO dto){
		panelService.savePanel(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getPanels(){
		List<PanelDTO> dto = panelService.findAllPanel();
		return new ResponseEntity<List<PanelDTO>>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{panelId}")
	public ResponseEntity<?> getPanel(@PathVariable("panelId") Long id){
		PanelDTO dto = panelService.findById(id);
		return new ResponseEntity<PanelDTO>(dto, HttpStatus.OK);

	}
	
	@PostMapping("{panelId}/file")
	public ResponseEntity<Void> uploadFile(
			@PathVariable("panelId") Long id,
			@RequestParam("file") MultipartFile file  ){
		
		System.out.println(file.getOriginalFilename());
		String fileName = fileStorageService.storeFile(file);
		panelService.addFileToPanel(id, fileName);
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
	
	
	
	
	
	
	@GetMapping("profile/{profileId}")
	public ResponseEntity<?> getPanelsByProfile(@PathVariable("profileId") Long id) {
		return new ResponseEntity<>(panelService.findAllByProfileId(id), HttpStatus.OK);
	}
	
	
	
	
}
