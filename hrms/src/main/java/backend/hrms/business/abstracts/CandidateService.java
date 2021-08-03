package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Candidate;

public interface CandidateService {

		DataResult<List<Candidate>> getAll();
	    DataResult<Candidate> getByIdentityNumber(String identityNumber);
	    DataResult<Candidate> get(int id);
	    Result add(Candidate candidate);
	    Result delete(Candidate candidate);
//	    Result update(Candidate candidate);
	
}
