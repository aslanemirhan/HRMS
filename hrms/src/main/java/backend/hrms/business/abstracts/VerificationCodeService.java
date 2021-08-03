package backend.hrms.business.abstracts;

import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	Result add(VerificationCode verificationCode);
	
}
