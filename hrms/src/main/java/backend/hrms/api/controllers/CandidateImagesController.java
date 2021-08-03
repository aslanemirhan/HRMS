package backend.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import backend.hrms.business.abstracts.CandidateImageService;
import backend.hrms.entities.concretes.Candidate;
import backend.hrms.entities.concretes.CandidateImage;

@RestController
@RequestMapping("/api/candidateimages/")
public class CandidateImagesController {

	private CandidateImageService candidateImageService;

	@Autowired
	public CandidateImagesController(CandidateImageService candidateImageService) {
		super();
		this.candidateImageService = candidateImageService;
	}
	
	@GetMapping("getImageByCandidateId")
    public ResponseEntity<?> getImageByCandidateId(@RequestParam int candidateId){
        return ResponseEntity.ok(this.candidateImageService.getCandidateImagesByCandidateId(candidateId));
    }


    @PostMapping("addCandidateImage")
    public ResponseEntity<?> addCandidateImage(@RequestBody MultipartFile file, @RequestParam int candidateId){
        Candidate candidate = new Candidate(); // dışarıdan doğrudan candidate alamazdık, input tan dosya eklediğimizde doğrudan RequestBody içerisindeki imageUrl alanına yazdıramazdık.
        CandidateImage candidateImage = new CandidateImage();

        candidate.setId(candidateId);
        candidateImage.setCandidate(candidate);

        return ResponseEntity.ok(this.candidateImageService.add(candidateImage, file));
    }
}
