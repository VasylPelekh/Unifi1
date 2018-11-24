package ua.unifi1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.unifi1.entity.FamilyEntity;
import ua.unifi1.entity.Profile;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyEntity, Long> {

	List<FamilyEntity> findByProfileId(Long id);

}
