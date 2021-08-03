package backend.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.hrms.business.abstracts.UserService;
import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.ErrorResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessDataResult;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.dataAccess.abstracts.UserDao;
import backend.hrms.entities.concretes.User;


@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

//	@Override
//	public DataResult<User> get(int id) {
//		return new SuccessDataResult<User>(this.userDao.getById(id));
//	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Added");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}

	@Override
	public Result checkUserExistByEmail(String email) {
		var userEmail = getByEmail(email);
		
		if(userEmail.getData() !=null){
	           return new ErrorResult("This email address has been used before.");
	        }

	        return new SuccessResult();
	}

}
