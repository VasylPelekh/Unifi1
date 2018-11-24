package ua.unifi1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.unifi1.domain.AdressDTO;
import ua.unifi1.domain.EducationDTO;
import ua.unifi1.entity.AdressEntity;
import ua.unifi1.entity.EducationEntity;
import ua.unifi1.entity.FamilyEntity;
import ua.unifi1.entity.Profile;
import ua.unifi1.entity.SexType;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	@Query("SELECT f FROM Profile f WHERE f.firstName = :firstName")
	List<Profile> findAllProfileByFirstName(@Param("firstName") String firstName);
	
	@Query("SELECT f FROM Profile f WHERE f.lastName = :lastName")
	List<Profile> findAllProfileByLastName(@Param("lastName") String lastName);
	
	@Query("SELECT a FROM Profile a WHERE a.age = :age")
	List<Profile> findAllProfileByAge(@Param("age") Integer age);
	
	@Query("SELECT s FROM Profile s WHERE s.sex = :sex")
	List<Profile> findAllProfileBySexType(@Param("sex") SexType sex);
	
	List<Profile> findByAdressId(Long id);
	
	List<Profile> findByEducationId(Long id);
	
	@Query("SELECT e FROM Profile e WHERE e.email = :email")
	Profile findByProfileEmail(@Param("email") String email);
	
	@Query("SELECT n FROM Profile n WHERE n.phoneNumber = :phoneNumber")
	Profile findByProfilePhone(@Param("phoneNumber") String phoneNumber);
}
