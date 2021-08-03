package backend.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.hrms.business.abstracts.EmployeeService;
import backend.hrms.entities.concretes.Employee;


@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	 @GetMapping("/getall")
	   public ResponseEntity<?> getAll(){
	       return ResponseEntity.ok(employeeService.getAll());
	   }
	 
	 @GetMapping("/get")
	   public ResponseEntity<?> get(int id){
	       return ResponseEntity.ok(this.employeeService.get(id));
	   }
	 
	 @PostMapping("/add")
	    public void add(@RequestBody Employee employee){
		 employeeService.add(employee);
	    }
	 
	 @PostMapping("/delete")
	    public void delete(@RequestBody Employee employee){
		 employeeService.delete(employee);
	    }
	 
	 
}
