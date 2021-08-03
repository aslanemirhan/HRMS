package backend.hrms.business.abstracts;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.User;

public interface UserService {

	
//	DataResult<User> get(int id);
	Result add(User user);
	DataResult<User> getByEmail(String email);
	Result checkUserExistByEmail(String email);
	
}
