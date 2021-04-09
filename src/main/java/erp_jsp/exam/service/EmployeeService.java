package erp_jsp.exam.service;

import java.sql.Connection;
import java.util.List;

import erp_jsp.exam.ds.jndiDS;
import erp_jsp.exam.dto.Employee;
import erp_jsp.exam.impl.EmployeeImpl;

public class EmployeeService {
	private Connection con = jndiDS.getConnection();
	private EmployeeImpl dao = EmployeeImpl.getInstance();
	
	public EmployeeService() {
		dao.setCon(con);
	}
	public List<Employee> showEmployees(){
		return dao.selectEmployeeByAll();		
	}
	
}
