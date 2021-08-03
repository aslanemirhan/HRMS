package backend.hrms.business.concretes;


import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import backend.hrms.business.abstracts.CandidateImageService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.core.utilities.uploadService.image.cloudinary.CloudinaryService;
import backend.hrms.dataAccess.abstracts.CandidateImageDao;
import backend.hrms.entities.concretes.CandidateImage;

@Service
public class CandidateImageManage implements CandidateImageService{

	private CloudinaryService cloudinaryService;
    private CandidateImageDao candidateImageDao;


    @Autowired
	public CandidateImageManage(CloudinaryService cloudinaryService, CandidateImageDao candidateImageDao) {
		super();
		this.cloudinaryService = cloudinaryService;
		this.candidateImageDao = candidateImageDao;
	}

	@Override
	public DataResult<CandidateImage> getCandidateImagesByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateImage>(this.candidateImageDao.findByCandidateId(candidateId));
	}

	@Override
	public Result add(CandidateImage candidateImage, MultipartFile file) {
		
		@SuppressWarnings("rawtypes")
		Map result = (Map) this.cloudinaryService.savePhoto(file).getData();
        String imageUrl = result.get("url").toString();
        candidateImage.setImageUrl(imageUrl);
        candidateImage.setCreatedAt(LocalDate.now());
        this.candidateImageDao.save(candidateImage);
        return new SuccessResult("Image uploaded.");
	}

}
