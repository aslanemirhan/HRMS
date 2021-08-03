package backend.hrms.api.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.EmployerService;
import backend.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")

public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	
	 @GetMapping("/getall")
	   public ResponseEntity<?> getAll(){
	       return ResponseEntity.ok(employerService.getAll());
	   }
	
	
	 @GetMapping("/get")
	   public ResponseEntity<?> get(int id){
	       return ResponseEntity.ok(this.employerService.get(id));
	   }
	 
	  @PostMapping("/add")
	    public void add(@RequestBody Employer employer){
	        this.employerService.add(employer);	
	    }
	  
	  @PostMapping("/delete")
	    public void delete(@RequestBody Employer employer){
	        this.employerService.delete(employer);	
	    }	
	  
	  @PostMapping("/update")
	    public void update(@RequestBody Employer employer){
	        this.employerService.update(employer);
	    }
	
	
}
