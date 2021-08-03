package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {

	DataResult<List<ForeignLanguage>> getForeignLanguagesByCandidateId(int candidateId);
    Result addForeignLanguage(ForeignLanguage foreignLanguage);
	
}
