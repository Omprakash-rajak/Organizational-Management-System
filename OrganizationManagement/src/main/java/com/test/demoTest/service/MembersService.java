package com.test.demoTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demoTest.entity.Employees;
import com.test.demoTest.entity.Members;
import com.test.demoTest.entity.Teams;
import com.test.demoTest.repository.MemberRepository;
import com.test.demoTest.repository.TeamRepository;

@Service
public class MembersService {
	@Autowired
	private MemberRepository repository;
	@Autowired

	private TeamRepository teamRepo;
	@Autowired
	TeamsService s;

	public Members saveMember(Members emp) {
		return repository.save(emp);
	}

	public List<Members> InitializeMembers(List<Members> emps) {
		return repository.saveAll(emps);
	}

	public List<Members> getAllMembers() {
		return repository.findAll();
	}

	public Members getMemberById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Members getMemberByName(String name) {
		return repository.findByName(name);
	}

	public String deleteMember(int id) {
		repository.deleteById(id);
		return "product removed !! " + id;
	}

	public Members updateMember(Members emp) {
		Members member = repository.findById(emp.getId()).orElse(null);
		member.setName(emp.getName());
		member.setAge(emp.getAge());
		member.setRole(emp.getRole());
		member.setSalary(emp.getSalary());
		member.setJoiningDate(emp.getJoiningDate());
		member.setTotalHoursWorked(emp.getTotalHoursWorked());
		member.setTotalWorkload(emp.getTotalWorkload());

		return repository.save(member);
	}

	public Members reassignMemberToTeam(int memberId, int newTeamId) {
		Members member = repository.findById(memberId).orElse(null);
		if (member == null) {
			throw new IllegalArgumentException("Member not found with ID: " + memberId);
		}

		Teams newTeam = teamRepo.findById(newTeamId).orElse(null);
		if (newTeam == null) {
			throw new IllegalArgumentException("Team not found with ID: " + newTeamId);
		}

		member.setTeamid(newTeamId);
		int m = s.getManagerIDByTeamId(newTeamId);
		member.setReportsTo(m);
		return repository.save(member);
	}

	public Members changeMemberRole(int memberId, String newRole) {
		Members member = repository.findById(memberId).orElse(null);
		if (member == null) {
			throw new IllegalArgumentException("Member not found with ID: " + memberId);
		}

		member.setRole(newRole);
		
		

		return repository.save(member);
	}
}
