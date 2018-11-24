package ua.unifi1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.unifi1.entity.AdressEntity;

@Repository
public interface AdressRepository extends JpaRepository<AdressEntity, Long> {
	
}
