package backend.hrms.business.abstracts;

import java.util.List;

import backend.hrms.core.utilities.results.DataResult;
import backend.hrms.core.utilities.results.Result;
import backend.hrms.entities.concretes.Employee;


public interface EmployeeService {

	DataResult<List<Employee>> getAll();
	DataResult<Employee> get(int id);
	Result add(Employee employee);
	Result delete(Employee employee);
}
