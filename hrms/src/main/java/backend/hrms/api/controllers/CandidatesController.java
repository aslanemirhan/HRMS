package backend.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.CandidateService;
import backend.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	 	@GetMapping("/getall")
	    public ResponseEntity<?> getAll(){
	        return ResponseEntity.ok(this.candidateService.getAll());
	    }
	 	
	 	 @GetMapping("/get")
	     public ResponseEntity<?> get(int id){
	         return ResponseEntity.ok(this.candidateService.get(id));
	     }
	 	 
	 	 @PostMapping("/add")
	 	   public void add(@RequestBody Candidate candidate){
	 	       candidateService.add(candidate);
	 	   }
	 	 
	 	 @PostMapping("delete")
	 	   public void delete(@RequestBody Candidate candidate){
	 	       candidateService.delete(candidate);
	 	   }
	

}
