package backend.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education,Integer>{

	List<Education> findAllByCandidateIdOrderByDateOfGraduation(int candidateId);
	
}
