package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();
//	DataResult<JobTitle> findByJobTitle(String jobTitle);
//	DataResult<JobTitle> findById(int id);
	Result add(JobTitle jobTitle);
	Result delete(JobTitle jobTitle);
	Result update(JobTitle jobTitle);
}
