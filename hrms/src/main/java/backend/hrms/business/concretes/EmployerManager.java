package backend.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.EmployerService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.EmployerDao;
import backend.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data Listed");
	}

	@Override
	public DataResult<Employer> get(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id).get());
	}

	@Override
	public Result add(Employer employer) {
		
//		var result = BusinessRules.run(checkNullFields(employer), checkEmailIsCompatibleWithDomain(employer));
//        if (!result.isSuccess()){
//            return new ErrorResult(result.getMessage());
//        }

        this.employerDao.save(employer);
        return new SuccessResult("Added.");
	}
	
	  @Override
	    public Result update(Employer employer) {
	        this.employerDao.save(employer);
	        return new SuccessResult("Updated.");
	    }

		@Override
		public Result delete(Employer employer) {
			this.employerDao.delete(employer);
			return new SuccessResult("Employer Deleted");
		}
	
	

	
//	  private Result checkEmailIsCompatibleWithDomain(Employer employer){
//
//	        String[] isEmailCompatible = employer.getEmail().split("@",2); // @ işaretinden iki ayrı parçaya böler
//	        String webSite = employer.getWebAddress().substring(4); // www. kısmından sonrasını alır
//
//	        if (!isEmailCompatible[1].equals(webSite)){
//	            return new ErrorResult("Your Email adress is not compatible with your Web Site domain.");
//	        }
//
//	        return new SuccessResult();
//	    }
//
//	    private  Result checkNullFields(Employer employer){
//	        if(employer.getWebAddress() == null){
//	            return new ErrorResult("Field Web Site cannot be blank.");
//	        }
//
//	        else if(employer.getCompanyName() == null){
//	            return new ErrorResult("Field Company Name cannot be blank.");
//	        }
//
//	        else if(employer.getEmail() == null){
//	            return new ErrorResult("Field Email cannot be blank.");
//	        }
//
//	        else if(employer.getPhoneNumber() == null){
//	            return new ErrorResult("Field Phone Number cannot be blank.");
//	        }
//	        
//	        else {
//
//	        return new SuccessResult("Employer Added");
//	        }
//	    }
	
	

}
