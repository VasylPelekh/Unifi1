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

import ua.unifi1.domain.MessageDTO;
import ua.unifi1.service.MessageService;


@RestController
@RequestMapping("message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping("/add")
	public ResponseEntity<Void> addMessage(@RequestBody MessageDTO dto){
		messageService.saveMessage(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getMessages(){
		List<MessageDTO> dto = messageService.findAllMessage();
		return new ResponseEntity<List<MessageDTO>>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/{messageId}")
	public ResponseEntity<?> getMessage(@PathVariable("messageId") Long id){
		MessageDTO dto = messageService.findById(id);
		return new ResponseEntity<MessageDTO>(dto, HttpStatus.OK);

	}
}
