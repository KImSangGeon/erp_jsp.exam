package erp_jsp.exam.dao;

import java.util.List;

import erp_jsp.exam.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	Employee selectEmployeeByNo(Employee employee);
	
	int insertEmployee(Employee employee);
	int updateEmployee(Employee employee);
	int deleteEmployee(Employee employee); 
}
