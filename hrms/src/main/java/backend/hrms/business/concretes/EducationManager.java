package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.EducationService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.EducationDao;
import backend.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService{

	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAllEducationsByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByCandidateIdOrderByDateOfGraduation(candidateId));
	}

	@Override
	public Result addEducation(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Education Added");
	}

}
