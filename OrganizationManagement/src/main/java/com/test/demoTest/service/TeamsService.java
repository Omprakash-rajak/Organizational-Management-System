package com.test.demoTest.service;

import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demoTest.entity.Employees;
import com.test.demoTest.entity.Members;
import com.test.demoTest.entity.Teams;
import com.test.demoTest.repository.EmpRepository;
import com.test.demoTest.repository.MemberRepository;
import com.test.demoTest.repository.TeamRepository;

import jakarta.transaction.Transactional;

@Service
public class TeamsService {
	@Autowired
	private TeamRepository repository;
	@Autowired
	private EmpRepository repository1;
	@Autowired
	private MemberRepository repository2;

	public Teams saveTeam(Teams emp) {
		
		return repository.save(emp);
	}

	public List<Teams> InitializeTeam(List<Teams> emps) {
		return repository.saveAll(emps);
	}

	public List<Teams> getAllTeams() {
		return repository.findAll();
	}

	public Teams getTeamById(int id) {
		return repository.findById(id).orElse(null);
	}

//	@Transactional
//	public Teams updateTeam(Teams team) {
//		// Retrieve the existing team from the database
//		Teams existingTeam = repository.findById(team.getId()).orElse(null);
//
//		// Check if the existing team exists
//		if (existingTeam != null) {
//			// Update the properties of the existing team with the new values
//			existingTeam.setName(team.getName());
//			existingTeam.setManager(team.getManager());
//
//			// Save the updated team back to the database
//			return repository.save(existingTeam);
//		} else {
//			// If the team with the given ID doesn't exist, you may choose to throw an
//			// exception or handle it accordingly
//			throw new RuntimeException("Team not found with ID: " + team.getId());
//		}
//	}
//	public Teams updateTeam(Teams team) {
//		
//		Teams existingTeam = repository.findById(team.getId()).orElse(null);
//		
//		existingTeam.setName(team.getName());
//		
//		existingTeam.setManager(team.getManager());
//
//		return repository.save(existingTeam);
//	}

	
	  public String getManagerByTeamId(int teamId) {
		  Teams team =repository.findById(teamId).orElse(null); 
		  int ManagerID = team.getManager_id();
		Employees  m = repository1.findById(ManagerID).orElse(null); 
		  String name = m.getName();
	  return name; }
	  
	  public int getManagerIDByTeamId(int teamId) {
		  Teams team =repository.findById(teamId).orElse(null); 
		  int ManagerID = team.getManager_id();
		  return ManagerID;
	  }

	public String deleteEmp(int id) {
		repository.deleteById(id);
		return "product removed !! " + id;
	}

	
	 public List<Members> getAllMembersByTeamId(int teamId) { 
		 Teams team =repository.findById(teamId).orElse(null); 
		 if (team != null) { 
			 return repository2.findByTeamid(teamId); } 
		 else { throw new RuntimeException("Team not found with ID: " + teamId); } }
	 
	public double getTeamTotalEfforts(int teamId) {
		Teams team = repository.findById(teamId).orElse(null);
		if (team != null) {
			List<Members> members = repository2.findByTeamid(teamId);
			if (!members.isEmpty()) {
				double totalEfforts = 0.0;
				for (Members member : members) {
					totalEfforts += member.getTotalHoursWorked(); // Assuming there's a method to get working hours for
																	// a
																	// member
				}
				int numberOfMembers = members.size();
				return totalEfforts / numberOfMembers;
			} else {
				throw new RuntimeException("No members found for team with ID: " + teamId);
			}
		} else {
			throw new RuntimeException("Team not found with ID: " + teamId);
		}
	}
	
	 public String changeManagerId(int teamId, int newManagerId) {
	        
	        Teams team = repository.findById(teamId).orElse(null);
	        
	       
	        if (team != null) {
	            
	            team.setManager_id(newManagerId);
	            
	            List<Members> members = getAllMembersByTeamId(teamId);

	            
	            int managerId = getManagerIDByTeamId(teamId);

	            
	            for (Members member : members) {
	                member.setReportsTo(managerId);
	            }

	            
	             repository2.saveAll(members);
	        
	            repository.save(team);
	            
	            return "Manager ID updated successfully for team with ID: " + teamId;
	        }
	         else {
	            
	            throw new RuntimeException("Team not found with ID: " + teamId);
	        }
	    }
}

