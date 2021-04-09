select EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE from employee;
select EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE from employee where emp_no = 1003;

insert into employee values(2105, '김수희', 5, 3011, 1400000, 2, '2020-08-30');
delete from employee where emp_no= 2105;

insert into employee values(?, ?, ?, ?, ?, ?, ?);

update employee set emp_name = '김미지', tno = 5, manager = 4377, salary = 2300000, dno = 3 where emp_no =2105; 