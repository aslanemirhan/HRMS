package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.CurriculumVitaeService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import backend.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManger implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVitaeDao;
	
	@Autowired
	public CurriculumVitaeManger(CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getCurriculumVitaesByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAllByCandidateId(candidateId));
	}

	@Override
	public Result addCurriculumVitae(CurriculumVitae curriculumVitae) {
		 this.curriculumVitaeDao.save(curriculumVitae);
	     return new SuccessResult();
	}

	

	   

	
}
