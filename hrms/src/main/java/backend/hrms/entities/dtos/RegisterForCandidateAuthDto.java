package backend.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RegisterForCandidateAuthDto extends AuthDto{

		private String firstName;
	    private String lastName;
	    private String nationalId;
	    private LocalDate dateOfBirth;
	    private String passwordConfirm;
}
