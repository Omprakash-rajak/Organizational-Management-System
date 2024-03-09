package com.test.demoTest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.demoTest.entity.Employees;
import com.test.demoTest.entity.Members;
import com.test.demoTest.service.EmployeesService;
import com.test.demoTest.service.MembersService;

@RestController
public class MemberController {
	
	@Autowired
	private MembersService service;

	@PostMapping("/addmember")
	public Members addEmp(@RequestBody Members emp) {
		return service.saveMember(emp);
	}

	@PostMapping("/addAllMembers")
	public List<Members> addEmployeess(@RequestBody List<Members> member) {
		return service.InitializeMembers(member);
	}

	@GetMapping("/GetAllMembers")
	public List<Members> findAllEmployeess() {
		return service.getAllMembers();
	}

	@GetMapping("/MemberById/{id}")
	public Members findMemberById(@PathVariable int id) {
		return service.getMemberById(id);
	}
	@GetMapping("/MemberByName/{name}")
	public Members getMemberByName(@PathVariable String name) {
		return service.getMemberByName(name);
	}

	@PutMapping("/updateMember")
	public Members updateMember(@RequestBody Members mem) {
		return service.updateMember(mem);
	}

	@DeleteMapping("/deleteMember/{id}")
	public String deleteEmploy(@PathVariable int id) {
		return service.deleteMember( id);
	}
	@PutMapping("/members/{memberId}/reassign/{newTeamId}")
	public  Members reassignMemberToTeam(@PathVariable int memberId, @PathVariable int newTeamId) {
		return service.reassignMemberToTeam(memberId, newTeamId);
	}
	@PostMapping("/members/change-role/{memberId}/{newRole}")
	 public Members changeMemberRole(@PathVariable int memberId, @PathVariable String newRole) {
		 return service.changeMemberRole(memberId, newRole);
	 }
	 
	
}
