<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<link rel = "stylesheet" href = "css/emplist.css">
</head>
<body>
<h2>직원 목록</h2>
		<table>
			<thead>
					<td>직원번호</td>
					<td>직책이름</td>
					<td>직책</td>
					<td>직속상사</td>
					<td>급여</td>
					<td>부서</td>
					<td>입사일</td>
			</thead>
			<tbody>
			<c:forEach var ="emp" items = "${list}">
					<tr>
						<td>${emp.no}</td>
							<td>${emp.name}</td>
							<td>${emp.TitleList()}</td>
							<td>${emp.ManagerList()}</td>
							<td><fmt:formatNumber value = "${emp.salary}" pattern="#,###"/></td>
							<td>${emp.DeptList()}</td>
		<td><fmt:formatDate value="${emp.hireDate}" type = "date" pattern="yyyy년 MM월 dd일"/></td>
						
							
					</tr>					
			</c:forEach>				
			</tbody>
		</table>

</body>
</html>