package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	DataResult<Employer> get(int id);
	Result add(Employer employer);
	Result delete(Employer employer);
	Result update(Employer employer);
	
	
}
