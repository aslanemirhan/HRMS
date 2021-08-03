package backend.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.ForeignLanguageService;
import backend.hrms.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("/api/foreignlanguage/")
public class ForeignLanguagesController {

	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}
	
	@GetMapping("getForeignLanguagesByCandidateId")
    public ResponseEntity<?> getForeignLanguagesByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.foreignLanguageService.getForeignLanguagesByCandidateId(candidateId));
    }


    @PostMapping("addForeignLanguage")
    public ResponseEntity<?> addForeignLanguage(@RequestBody @Valid ForeignLanguage foreignLanguage){
        return ResponseEntity.ok(this.foreignLanguageService.addForeignLanguage(foreignLanguage));
    }
}
