package backend.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.UserService;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.core.utilities.results.SuccessResult;
import backend.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
//		@GetMapping("/get")
//	    public ResponseEntity<?> get(int id) {
//	        return ResponseEntity.ok(userService.get(id));
//	        
//	    }

	    @PostMapping("/add")
	    public Result add(@RequestBody User user) {
	        this.userService.add(user);
	        return new SuccessResult("Added");
	        		
	    }
	
	
}
