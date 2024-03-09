package com.test.demoTest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.demoTest.entity.Employees;
import com.test.demoTest.service.EmployeesService;

import java.sql.Date;
import java.util.List;

@RestController
public class EmpController {

	@Autowired
	private EmployeesService service;

	@PostMapping("/addEmployees")
	public Employees addEmp(@RequestBody Employees emp) {
		return service.saveEmp(emp);
	}

	@PostMapping("/addEmployeess")
	public List<Employees> addEmployeess(@RequestBody List<Employees> Employeess) {
		return service.saveEmps(Employeess);
	}

	@GetMapping("/Employeess")
	public List<Employees> findAllEmployeess() {
		return service.getEmps();
	}

	@GetMapping("/EmployeeById/{id}")
	public Employees findEmployeesById(@PathVariable int id) {
		return service.getEmpById(id);
	}
	@GetMapping("/EmployeeByName/{name}")
	public Employees getEmpByName(@PathVariable String  name) {
		return service.getEmpByName(name);
	}
	@GetMapping("/EmployeeByJoin/{joinDate}")
	public Employees getEmpByJoinDate(@PathVariable Date joinDate) {
		return service.getEmpByjoinDate(joinDate);
	}


	@PutMapping("/updateEMP")
	public Employees updateEmployees(@RequestBody Employees Employees) {
		return service.updateEmp(Employees);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployees(@PathVariable int id) {
		return service.deleteEmp(id);
	}
	 @PostMapping("/calculateSalary/{employeeId}")
	    public double calculateSalary(@PathVariable int employeeId, @RequestParam int leavesTaken) {
		 return service.calculateSalary(employeeId, leavesTaken);
	 }
}
