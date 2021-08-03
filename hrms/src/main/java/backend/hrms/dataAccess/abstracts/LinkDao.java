package backend.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.hrms.entities.concretes.Link;

public interface LinkDao extends JpaRepository<Link,Integer>{

	List<Link> findAllByCandidateId(int candidateId);
}
