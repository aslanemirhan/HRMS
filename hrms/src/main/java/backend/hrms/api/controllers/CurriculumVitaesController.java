package backend.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.CurriculumVitaeService;
import backend.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumvitaes/")
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }


    @GetMapping("getCurriculumVitaesByCandidateId")
    public ResponseEntity<?> getCurriculumVitaesByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.curriculumVitaeService.getCurriculumVitaesByCandidateId(candidateId));
    }


    @PostMapping("addCurriculumVitae")
    public ResponseEntity<?> addCurriculumVitae(@RequestBody CurriculumVitae curriculumVitae){
        return ResponseEntity.ok(this.curriculumVitaeService.addCurriculumVitae(curriculumVitae));
    }
}
