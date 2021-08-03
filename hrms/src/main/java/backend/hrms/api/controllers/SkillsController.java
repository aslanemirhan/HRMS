package backend.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.SkillService;
import backend.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills/")
public class SkillsController {

	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@GetMapping("getSkillsByCandidateId")
    public ResponseEntity<?> getSkillsByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.skillService.getSkillsByCandidateId(candidateId));
    }


    @PostMapping("addSkill")
    public ResponseEntity<?> addSkill(@RequestBody Skill skill){
        return ResponseEntity.ok(this.skillService.addSkill(skill));
    }
	
}
