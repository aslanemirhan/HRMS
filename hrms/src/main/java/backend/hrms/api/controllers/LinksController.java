package backend.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.LinkService;
import backend.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/links/")
public class LinksController {

	private LinkService linkService;

    @Autowired
    public LinksController(LinkService linkService) {
        this.linkService = linkService;
    }


    @GetMapping("getLinksByCandidateId")
    public ResponseEntity<?> getLinksByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.linkService.getLinksByCandidateId(candidateId));
    }


    @PostMapping("addLink")
    public ResponseEntity<?> addLink(@RequestBody Link link){
        return ResponseEntity.ok(this.linkService.addLink(link));
    }
}
