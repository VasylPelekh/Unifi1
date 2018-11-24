package ua.unifi1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.unifi1.domain.MessageDTO;
import ua.unifi1.entity.MessageEntity;
import ua.unifi1.exception.ResourseNotFoundException;
import ua.unifi1.repository.MessageRepository;
import ua.unifi1.service.MessageService;
import ua.unifi1.utils.ObjectMapperUtils;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ObjectMapperUtils messageMapper;
	
	@Override
	public void saveMessage(MessageDTO dto) {
		MessageEntity entity = messageMapper.map(dto, MessageEntity.class);
		messageRepository.save(entity);
	}

	@Override
	public MessageDTO findById(Long id) {
		MessageEntity entity = messageRepository.findById(id).orElseThrow(
				() -> new ResourseNotFoundException("Record with id[" + id + "] not found")
				);
		MessageDTO dto = messageMapper.map(entity, MessageDTO.class);
		return dto;
	}

	@Override
	public List<MessageDTO> findAllMessage() {
		List<MessageEntity> entities = messageRepository.findAll();
		List<MessageDTO> dtos = messageMapper.mapAll(entities, MessageDTO.class);
		return dtos;
	}

}
