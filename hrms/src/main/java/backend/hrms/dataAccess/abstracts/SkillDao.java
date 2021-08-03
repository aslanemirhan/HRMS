package backend.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill,Integer>{

	List<Skill> findAllByCandidateId(int candidateId);
}
