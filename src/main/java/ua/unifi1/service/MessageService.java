package ua.unifi1.service;

import java.util.List;

import ua.unifi1.domain.MessageDTO;

public interface MessageService {

	void saveMessage (MessageDTO dto);

	MessageDTO findById(Long id);

	List<MessageDTO> findAllMessage();
}
