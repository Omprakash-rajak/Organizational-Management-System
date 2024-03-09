
package com.test.demoTest.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.demoTest.entity.Employees;


public interface EmpRepository extends JpaRepository<Employees,Integer> {
	public Employees findByName(String name);
	public Employees findBysalary( double salary);
	public Employees findByjoindate(Date joindate);
}

