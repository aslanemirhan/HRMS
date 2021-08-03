package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.adapters.mernis.MernisVerificationManager;
import backend.hrms.adapters.mernis.MernisVerificationService;
import backend.hrms.business.abstracts.CandidateService;
import backend.hrms.core.utilities.business.BusinessRules;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.ErrorResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.CandidateDao;
import backend.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private MernisVerificationService mernisVerificationService = new MernisVerificationManager();
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data Listed");
	}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByIdentityNumber(identityNumber));
	}

	@Override
	public DataResult<Candidate> get(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get());
	}

	@Override
	public Result add(Candidate candidate) {
		var result = BusinessRules.run(checkUserExistsByNationalId(candidate), this.mernisVerificationService.checkIfRealPerson(candidate));
        if (!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }

        this.candidateDao.save(candidate);	
        return new SuccessResult("Added.");
	}

	@Override
	public Result delete(Candidate candidate) {
		this.candidateDao.delete(candidate);
		return new SuccessResult("Candidate Deleted");
	}

//	@Override
//	public Result update(Candidate candidate) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
	   private Result checkUserExistsByNationalId(Candidate candidate){

	        var candidateNationalId = getByIdentityNumber(candidate.getIdentityNumber());
	        if(candidateNationalId.getData() !=null){
	            new ErrorResult("This identification number has been used before.");
	        }

	        return new SuccessResult();
	    }

}
