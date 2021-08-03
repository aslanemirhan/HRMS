package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Education;

public interface EducationService {

	DataResult<List<Education>> getAllEducationsByCandidateId(int candidateId);
    Result addEducation(Education education);
	
}
