package erp_jsp.exam.impl;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import erp_jsp.exam.ds.JdbcUtil;
import erp_jsp.exam.dto.Department;
import erp_jsp.exam.dto.Employee;
import erp_jsp.exam.dto.Title;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeImplTest {
	private static Connection con;
	private EmployeeImpl dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = JdbcUtil.getConnection();
	}

	@Before
	public void setUp() throws Exception {
		dao = EmployeeImpl.getInstance();
		dao.setCon(con);
	}
	

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectEmployeeByAll() {
		
		System.out.printf("%s%n", "testSelectEmployeeByAll");
		List<Employee> list = dao.selectEmployeeByAll();
		Assert.assertNotNull(list);
		for(Employee e : list) {		
			System.out.println(e);
		}
	}

	@Test
	public void test02SelectEmployeeByNo() {
		System.out.printf("%s%n", "testSelectEmployeeByNo");
		Employee employee = new Employee(1003);
		Employee selemployee = dao.selectEmployeeByNo(employee);
		Assert.assertNotNull(selemployee);
		System.out.println(selemployee);
		
	}

	@Test
	public void test03InsertEmployee() {
		System.out.printf("%s%n", "testInsertEmployee");
		Employee employee = new Employee(2105, "김수희", new Title(5), new Employee(3011), 1400000, new Department(2), new Date());
		int res = dao.insertEmployee(employee);		
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(employee));
	}

	@Test
	public void test04UpdateEmployee() {
		System.out.printf("%s%n", "test04UpdateEmployee");
		
		Calendar cal = GregorianCalendar.getInstance();
		cal.getTime();
		Employee employee = new Employee(3432, "김지리", new Title(2), new Employee(4377), 2000000, new Department(1), cal.getTime());
		int res = dao.updateEmployee(employee);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(new Employee(3432)));
	}


	 @Test
	 public void test05DeleteEmployee() 
	 { System.out.printf("%s%n","testDeleteEmployee");
	 Employee employee = new Employee(2105); int res =
	 dao.deleteEmployee(employee); Assert.assertEquals(1, res);
	 dao.selectEmployeeByAll().stream().forEach(System.out::println); 
	 }
	

}
