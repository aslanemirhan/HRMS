package backend.hrms.core.utilities.verification;

public interface VerificationService {

	void verificateWithVerificationLink(String email);
	String verificateWithVerificationCod();
	
}
