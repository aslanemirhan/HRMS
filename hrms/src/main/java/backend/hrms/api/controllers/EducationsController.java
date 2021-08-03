package backend.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.EducationService;
import backend.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/education")
public class EducationsController {

	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getAllSchoolsByCandidateId")
    public ResponseEntity<?> getAllSchoolsByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.educationService.getAllEducationsByCandidateId(candidateId));
    }
	
	 @PostMapping("/addEducation")
	 public ResponseEntity<?> addEducation(@RequestBody Education education){
	     return ResponseEntity.ok(this.educationService.addEducation(education));
	 }
	
}
