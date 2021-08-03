package backend.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.JobExperienceService;
import backend.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobexperience/")
public class JobExperiencesController {

	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	 @GetMapping("getJobExperiencesByCandidateId")
	 public ResponseEntity<?> getJobExperiencesByCandidateId(@RequestParam int candidateId){
	       return ResponseEntity.ok(this.jobExperienceService.getJobExperiencesByCandidateId(candidateId));
	 }
	
	 
	 @PostMapping("addJobExperience")
	 public ResponseEntity<?> addJobExperience(@RequestBody JobExperience jobExperience){
	       return ResponseEntity.ok(this.jobExperienceService.addJobExperience(jobExperience));
	 }
}
