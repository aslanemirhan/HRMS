package backend.hrms.api.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.JobAnnouncementService;
import backend.hrms.entities.concretes.JobAnnouncement;

@RestController
@RequestMapping("/api/jobannouncements")
public class JobAnnouncementsController {

	private JobAnnouncementService jobAnnouncementService;
	
	@Autowired
	public JobAnnouncementsController(JobAnnouncementService jobAnnouncementService) {
		super();
		this.jobAnnouncementService = jobAnnouncementService;
	}
	
	 	@GetMapping("/getallbyactive")
	    public ResponseEntity<?> getAllByActive(){
	        return ResponseEntity.ok(this.jobAnnouncementService.getAllByActive());
	    }
	 	
	 	
	 	 @GetMapping("/getalbyactiveandemployer")
	     public ResponseEntity<?> getAllByActiveAndEmployer(@RequestParam int employerId){
	         return ResponseEntity.ok(this.jobAnnouncementService.getAllByActiveAndEmployer(employerId));
	     }
	 	 
	 	 @GetMapping("/getallbyjobposition")
	 	 public ResponseEntity<?> getAllByJobTitle(@RequestParam int jobTitleId){
	 	      return ResponseEntity.ok(this.jobAnnouncementService.getAllByJobTitle(jobTitleId));
	 	  }
	 	 
//	 	@GetMapping("/getallbyannouncementdeadline")
//	    public ResponseEntity<?> getAllByAnnouncementDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
//	        return ResponseEntity.ok(this.jobAnnouncementService.getAllByAnnouncementDeadline(date));
//	    }
	 	 
	 	@GetMapping("/publishjobannouncement")
	    public ResponseEntity<?> publishJobAnnouncement(@RequestParam int jobAnnouncementId){
	        return ResponseEntity.ok(this.jobAnnouncementService.publishJobAnnouncement(jobAnnouncementId));
	    }
	 	
	 	 @GetMapping("/setpassivejobannouncement")
	     public ResponseEntity<?> setPassiveJobAnnouncement(@RequestParam int jobAnnouncementId){
	         return ResponseEntity.ok(this.jobAnnouncementService.setPassiveJobAnnouncement(jobAnnouncementId));
	     }
	 	 
	 	@PostMapping("addjobannouncement")
	    public ResponseEntity<?> addJobAnnouncement(@RequestBody JobAnnouncement jobAnnouncement){
	        return ResponseEntity.ok(this.jobAnnouncementService.addJobAnnouncement(jobAnnouncement));
	    }	 
	
}
