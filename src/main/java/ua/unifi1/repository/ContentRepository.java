package ua.unifi1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.unifi1.entity.ContentEntity;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Long> {

}
