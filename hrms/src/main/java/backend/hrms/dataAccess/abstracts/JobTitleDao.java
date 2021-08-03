package backend.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer>{

//	JobTitle findByJobTitle(String jobTitle);
}
