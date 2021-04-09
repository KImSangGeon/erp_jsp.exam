-- 데이터베이스시험
DROP SCHEMA IF EXISTS `erp_jsp_exam`;

-- 데이터베이스시험
CREATE SCHEMA `erp_jsp_exam`;

-- 직책 
CREATE TABLE `erp_jsp_exam`.`TITLE` (
	`TITLE_NO`   INTEGER     NOT NULL COMMENT '직책번호', -- 직책번호
	`TITLE_NAME` VARCHAR(20) NOT NULL COMMENT '직책명' -- 직책명
)
COMMENT '직책 ';

-- 직책 
ALTER TABLE `erp_jsp_exam`.`TITLE`
	ADD CONSTRAINT `PK_TITLE` -- 직책  기본키
		PRIMARY KEY (
			`TITLE_NO` -- 직책번호
		);

-- 부서
CREATE TABLE `erp_jsp_exam`.`DEPARTMENT` (
	`DEPT_NO`   INTEGER     NOT NULL COMMENT '부서번호', -- 부서번호
	`DEPT_NAME` VARCHAR(20) NULL     COMMENT '부서명', -- 부서명
	`FLOOR`     INTEGER     NULL     COMMENT '위치' -- 위치
)
COMMENT '부서';

-- 부서
ALTER TABLE `erp_jsp_exam`.`DEPARTMENT`
	ADD CONSTRAINT `PK_DEPARTMENT` -- 부서 기본키
		PRIMARY KEY (
			`DEPT_NO` -- 부서번호
		);

-- 사원
CREATE TABLE `erp_jsp_exam`.`EMPLOYEE` (
	`EMP_NO`   INTEGER     NOT NULL COMMENT '사원번호', -- 사원번호
	`EMP_NAME` VARCHAR(20) NOT NULL COMMENT '사원명', -- 사원명
	`TNO`      INTEGER     NULL     COMMENT '직책', -- 직책
	`MANAGER`  INTEGER     NULL     COMMENT '직속상사', -- 직속상사
	`SALARY`   INTEGER     NULL     COMMENT '급여', -- 급여
	`DNO`      INTEGER     NULL     COMMENT '부서', -- 부서
	`HIREDATE` DATE        NULL     COMMENT '입사일' -- 입사일
)
COMMENT '사원';

-- 사원
ALTER TABLE `erp_jsp_exam`.`EMPLOYEE`
	ADD CONSTRAINT `PK_EMPLOYEE` -- 사원 기본키
		PRIMARY KEY (
			`EMP_NO` -- 사원번호
		);

-- 사원
ALTER TABLE `erp_jsp_exam`.`EMPLOYEE`
	ADD CONSTRAINT `FK_TITLE_TO_EMPLOYEE` -- 직책  -> 사원
		FOREIGN KEY (
			`TNO` -- 직책
		)
		REFERENCES `erp_jsp_exam`.`TITLE` ( -- 직책 
			`TITLE_NO` -- 직책번호
		);

-- 사원
ALTER TABLE `erp_jsp_exam`.`EMPLOYEE`
	ADD CONSTRAINT `FK_EMPLOYEE_TO_EMPLOYEE` -- 사원 -> 사원
		FOREIGN KEY (
			`MANAGER` -- 직속상사
		)
		REFERENCES `erp_jsp_exam`.`EMPLOYEE` ( -- 사원
			`EMP_NO` -- 사원번호
		);

-- 사원
ALTER TABLE `erp_jsp_exam`.`EMPLOYEE`
	ADD CONSTRAINT `FK_DEPARTMENT_TO_EMPLOYEE` -- 부서 -> 사원
		FOREIGN KEY (
			`DNO` -- 부서
		)
		REFERENCES `erp_jsp_exam`.`DEPARTMENT` ( -- 부서
			`DEPT_NO` -- 부서번호
		);