package com.test.demoTest.entity;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.demoTest.repository.TeamRepository;
import com.test.demoTest.service.TeamsService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class Members {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double salary;
	private int age;
	private Date joiningDate;
	private int teamid;
	private int reportsTo;
	private int totalHoursWorked;
	private int totalWorkload;
	private String Role;

	
	//@ManyToMany
	//private Teams teams;


	public Members() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Date getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}


	public int getReportsTo() {
		
		return reportsTo;
	}


	public void setReportsTo(int reportsTo) {
		
		this.reportsTo = reportsTo;
		
	}


	public int getTotalHoursWorked() {
		return totalHoursWorked;
	}


	public void setTotalHoursWorked(int totalHoursWorked) {
		this.totalHoursWorked = totalHoursWorked;
	}


	public int getTotalWorkload() {
		return totalWorkload;
	}


	public void setTotalWorkload(int totalWorkload) {
		this.totalWorkload = totalWorkload;
	}


	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}


	public int getTeamid() {
		return teamid;
	}


	public void setTeamid(int teamid) {
		this.teamid = teamid;
		
		
	}


	public Members(int id, String name, double salary, int age, Date joiningDate, int teamid, 
			int totalHoursWorked, int totalWorkload, String role) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.joiningDate = joiningDate;
		this.teamid = teamid;
		//this.reportsTo = reportsTo;
		this.totalHoursWorked = totalHoursWorked;
		this.totalWorkload = totalWorkload;
		Role = role;
	}
	

}
