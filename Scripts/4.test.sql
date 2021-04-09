select EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE 
from employee;

select EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE
from employee where emp_no = 1003;

insert into employee values(2105, '김수희', 5, 3011, 1400000, 2, '2020-08-30');
insert into employee values(?, ?, ?, ?, ?, ?, ?);

update employee 
set emp_name = '김미지', tno = 5, manager = 4377, salary = 2300000, dno = 3 
where emp_no =2105; o = 3 where emp_no =2105; 

delete from employee where emp_no= 2105;
EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, HIREDATE
TITLE_NO, TITLE_NAME
DEPT_NO, DEPT_NAME, FLOOR
select *from employee;
select * from title;
select * from department ;

select EMP_NO, EMP_NAME, TITLE_NO, TITLE_NAME, MANAGER, manager_name, SALARY, DEPT_NO, DEPT_NAME, FLOOR,HIREDATE from vw_full_employee ;
create or replace view vw_full_employee
as
select e.EMP_NO,
	   e.EMP_NAME,
       t.TITLE_NO, 
       t.TITLE_NAME, 
       e.MANAGER, 
       m.EMP_NAME as manager_name,
       e.SALARY,
       d.DEPT_NO,
       d.DEPT_NAME,
       d.FLOOR,
       e.HIREDATE
from employee e join title t on e.TNO=t.TITLE_NO
left join employee m on e.MANAGER =m.EMP_NO 
join department d on e.DNO = d.DEPT_NO;

select EMP_NO, EMP_NAME, TITLE_NO, TITLE_NAME, MANAGER, manager_name, SALARY, DEPT_NO, DEPT_NAME, FLOOR,HIREDATE from vw_full_employee