package erp_jsp.exam.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import erp_jsp.exam.dto.Employee;
import erp_jsp.exam.service.EmployeeService;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeService service;
	
    public EmployeeServlet() {
    	service = new EmployeeService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		List<Employee> list = service.showEmployees();
		list.stream().forEach(System.out::println);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("emplist.jsp").forward(request, response);
	}
}
