package backend.hrms.core.utilities.business;

import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessResult;

public class BusinessRules {

	public static Result run(Result... logics){
        for (Result logic : logics) {
            if (!logic.isSuccess()){
                return logic;
            }
        }
        return new SuccessResult();
    }
	
}
