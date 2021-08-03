package backend.hrms.adapters.mernis;



import backend.hrms.core.utilities.business.BusinessRules;
import backend.hrms.core.utilities.results.ErrorResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.entities.concretes.Candidate;


public class MernisVerificationManager implements MernisVerificationService{

	@Override
	public Result checkIfRealPerson(Candidate candidate) {
		
		  var result = BusinessRules.run(checkNationalId(candidate.getIdentityNumber()),checkFirstName(candidate.getFirstName()),
	                checkLastName(candidate.getLastName()), checkBirthOfDate(candidate.getBirthYear()));
	        if (!result.isSuccess()){
	            return new ErrorResult(result.getMessage());
	        }
	        return new SuccessResult();
	}
	
	
	 private Result checkNationalId(String nationalId){

	        if(nationalId ==null){
	            return new ErrorResult("Field National Id cannot be blank ");
	        }

	        if (nationalId.length() != 11){
	            return new ErrorResult("National identity must consist of 11 characters.");
	        }

	        return new SuccessResult("National Id is validated.");

	    }
	 
	 private Result checkFirstName(String firstName){

	        if(firstName ==null){
	            return new ErrorResult("Field First Name cannot be blank ");
	        }

	        if (firstName.length() <2){
	            return new ErrorResult("The First Name must consist of a minimum of 2 characters.");
	        }

	        return new SuccessResult("First Name is validated.");
	    }
	 
	 private Result checkLastName(String lastName){

	        if(lastName ==null){
	            return new ErrorResult("Field Last Name cannot be blank ");
	        }

	        if (lastName.length() <2){
	            return new ErrorResult("The Last Name must consist of a minimum of 2 characters.");
	        }

	        return new SuccessResult("Last Name is validated.");
	    }

	 
	 private Result checkBirthOfDate(int birthOfDate){

	        if(birthOfDate <= 0){
	            return new ErrorResult("Field Birth of Date cannot be blank ");
	        }

	        

	        return new SuccessResult("Birth of date validated.");
	    }
	
	

}
