package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {

	DataResult<List<CurriculumVitae>> getCurriculumVitaesByCandidateId(int candidateId);
    Result addCurriculumVitae(CurriculumVitae curriculumVitae);
}
