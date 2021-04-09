package erp_jsp.exam.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import erp_jsp.exam.dao.EmployeeDao;
import erp_jsp.exam.dto.Department;
import erp_jsp.exam.dto.Employee;
import erp_jsp.exam.dto.Title;

public class EmployeeImpl implements EmployeeDao {
	
	private static EmployeeImpl instance = new EmployeeImpl();
	private Connection con;
	
	public static EmployeeImpl getInstance() {
		return instance;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public List<Employee> selectEmployeeByAll() {
		String sql = "select EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE from employee";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
//		EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE
		int no = rs.getInt("EMP_NO");
		String name = rs.getString("EMP_NAME");
		Title tno = new Title(rs.getInt("TNO"));
		Employee manager = new Employee(rs.getInt("MANAGER"));
		int salary = rs.getInt("SALARY");
		Department dno = new Department(rs.getInt("DNO"));
		Date hireDate = rs.getTimestamp("HIREDATE");
		return new Employee(no, name, tno, manager, salary, dno, hireDate);
	}

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		String sql = "select EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE from employee where emp_no = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, employee.getNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getEmployee(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertEmployee(Employee employee) {
//		EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE
		String sql = "insert into employee values(?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, employee.getNo());
			pstmt.setString(2, employee.getName());
			pstmt.setInt(3, employee.getTitle().getNo());
			pstmt.setInt(4, employee.getManager().getNo());
			pstmt.setInt(5, employee.getSalary());
			pstmt.setInt(6, employee.getDept().getNo());
			pstmt.setTimestamp(7, new Timestamp(employee.getHireDate().getTime()));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		
//		EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE, EMP_NO
		String sql = "update employee set emp_name = ?, tno = ?, manager = ?, salary = ?, dno = ?, hiredate = ? where emp_no = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, employee.getName());
			pstmt.setInt(2, employee.getTitle().getNo());
			pstmt.setInt(3, employee.getManager().getNo());
			pstmt.setInt(4, employee.getSalary());
			pstmt.setInt(5, employee.getDept().getNo());
			pstmt.setTimestamp(6, new Timestamp(employee.getHireDate().getTime()));
			pstmt.setInt(7, employee.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int deleteEmployee(Employee employee) {
		String sql = "delete from employee where emp_no= ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, employee.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
