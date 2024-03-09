package com.test.demoTest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.demoTest.entity.Employees;
import com.test.demoTest.entity.Members;
import com.test.demoTest.entity.Teams;
import com.test.demoTest.service.EmployeesService;
import com.test.demoTest.service.TeamsService;

@RestController
public class TeamController {

	@Autowired
	private TeamsService service1;

	@PostMapping("/addTeams")
	public Teams addTeam(@RequestBody Teams t) {
		return service1.saveTeam(t);
	}

	@PostMapping("/InitialLize")
	public List<Teams> InitializeTeam(@RequestBody  List<Teams> teams) {
		return service1.InitializeTeam(teams);
	}

	@GetMapping("/getAllTeam")
	public List<Teams> getAllTeams() {
		return service1.getAllTeams();
	}

//	@PutMapping("/updateTeam")
//	public Teams updateEmployees(@RequestBody Teams teams) {
//		return service1.updateTeam(teams);
//	}
	@PostMapping("/changeManagerId/{teamId}/{newManagerId}")
	public String changeManagerIdEndpoint(@PathVariable int teamId, @PathVariable int newManagerId) {
		return service1.changeManagerId(teamId, newManagerId);
	}
	
	  @GetMapping("/getManager/{teamId}") 
	  public String sgetManagerByTeamId(@PathVariable int teamId) { return
	 service1.getManagerByTeamId(teamId); }
	 
	  @GetMapping("/getTeamMember/{teamId}") 
	  public List<Members>getAllMembersByTeamId(@PathVariable int teamId) {
	  
	 return service1.getAllMembersByTeamId(teamId); }
	 
	 @GetMapping("/getTeamTotalEffort/{teamId}") public double
	 getTeamTotalEfforts(@PathVariable int teamId) { return
	 service1.getTeamTotalEfforts(teamId); }
	 
}
