package com.test.demoTest.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demoTest.entity.Employees;
import com.test.demoTest.repository.EmpRepository;

@Service
public class EmployeesService {
	@Autowired
	private EmpRepository repository;

	public Employees saveEmp(Employees emp) {
		return repository.save(emp);
	}

	public List<Employees> saveEmps(List<Employees> emps) {
		return repository.saveAll(emps);
	}

	public List<Employees> getEmps() {
		return repository.findAll();
	}

	public Employees getEmpById(int id) {
		return repository.findById(id).orElse(null);
	}
	public Employees getEmpByName(String  name) {
		return repository.findByName(name);
	}
	public Employees getEmpByjoinDate(Date  name) {
		return repository.findByjoindate(name);
	}
	public String deleteEmp(int id) {
		repository.deleteById(id);
		return "product removed !! " + id;
	}

	public Employees updateEmp(Employees emp) {
		Employees existingEmp = repository.findById(emp.getId()).orElse(null);
		existingEmp.setName(emp.getName());
		existingEmp.setAge(emp.getAge());
		existingEmp.setSalary(emp.getSalary());

		return repository.save(existingEmp);
	}

	public double calculateSalary(int employeeId, int leavesTaken) {

		Employees employee = getEmpById(employeeId);
		if (employee == null) {

			return -1;
		}

		double baseSalary = employee.getSalary();
		double s = baseSalary / 30;

		double salaryAfterLeaves = baseSalary - (leavesTaken * s);

		if (salaryAfterLeaves < 0) {
			salaryAfterLeaves = 0;
		}

		return salaryAfterLeaves;
	}

}
