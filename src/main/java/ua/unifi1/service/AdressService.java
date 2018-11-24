package ua.unifi1.service;

import java.util.List;

import ua.unifi1.domain.AdressDTO;


public interface AdressService {

	void saveAdress (AdressDTO dto);

	AdressDTO findById(Long id);

	List<AdressDTO> findAllAdress();
}
