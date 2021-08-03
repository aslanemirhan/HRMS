package backend.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{

}
