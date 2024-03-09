package com.test.demoTest.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class Teams {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int manager_id;

//	//@ManyToOne
//	private Employees manager;
//
//	@OneToMany(mappedBy = "teams")
//	private List<Members> members;

	
	public Teams() {
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

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

public Teams(int id, String name, int manager_id) {
	super();
	this.id = id;
	this.name = name;
	this.manager_id = manager_id;
}

}
