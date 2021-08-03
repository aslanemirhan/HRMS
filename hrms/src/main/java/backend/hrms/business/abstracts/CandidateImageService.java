package backend.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.CandidateImage;

public interface CandidateImageService {

	DataResult<CandidateImage> getCandidateImagesByCandidateId(int candidateId);
    Result add(CandidateImage candidateImage, MultipartFile file);
}
