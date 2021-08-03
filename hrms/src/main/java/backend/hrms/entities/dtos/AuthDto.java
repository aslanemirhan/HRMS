package backend.hrms.entities.dtos;

import backend.hrms.entities.abstracts.Dto;
import lombok.Data;

@Data
public class AuthDto implements Dto{

	private String email;
    private String password;
}
