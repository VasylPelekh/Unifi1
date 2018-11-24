package ua.unifi1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.unifi1.entity.FamilyEntity;
import ua.unifi1.entity.PanelEntity;

@Repository
public interface PanelRepository extends JpaRepository<PanelEntity, Long> {

	List<PanelEntity> findByProfileId(Long id);
}
