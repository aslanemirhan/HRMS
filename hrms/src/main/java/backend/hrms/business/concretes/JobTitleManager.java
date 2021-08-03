package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.JobTitleService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.ErrorResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.JobTitleDao;
import backend.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Data Listed");
	}

//	@Override
//	public DataResult<JobTitle> findByJobTitle(String jobTitle) {
//		return new SuccessDataResult<JobTitle>(this.jobTitleDao.findByJobTitle(jobTitle));
//	}

//	@Override
//	public DataResult<JobTitle> findById(int id) {
//		return new SuccessDataResult<JobTitle>(this.jobTitleDao.findById(id).get());
//	}

	@Override
	public Result add(JobTitle jobTitle) {
//		  var result = findByJobTitle(jobTitle.getTitle());
//	        if (result != null) {
//	            return new ErrorResult("Job Position exists.");
//	        }
//
//	        return new SuccessResult("Added.");
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Added");
	}

	@Override
	public Result delete(JobTitle jobTitle) {
		this.jobTitleDao.delete(jobTitle);
		return new SuccessResult("JobTitle Deleted");
	}

	@Override
	public Result update(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("JobTitle Updated");
	}

}
