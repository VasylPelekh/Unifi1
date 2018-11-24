package ua.unifi1.service;

import java.util.List;
import ua.unifi1.domain.ContentDTO;

public interface ContentService {

	void saveContent (ContentDTO dto);

	ContentDTO findById(Long id);

	List<ContentDTO> findAllContent();
}
