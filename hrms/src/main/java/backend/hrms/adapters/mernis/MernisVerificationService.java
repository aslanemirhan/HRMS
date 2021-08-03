package backend.hrms.adapters.mernis;

import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Candidate;

public interface MernisVerificationService {

	Result checkIfRealPerson(Candidate candidate);
	
}
