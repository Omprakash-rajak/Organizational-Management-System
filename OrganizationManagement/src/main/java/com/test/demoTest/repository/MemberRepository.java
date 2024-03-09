package com.test.demoTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.demoTest.entity.Members;
import com.test.demoTest.entity.Teams;

public interface MemberRepository extends JpaRepository<Members, Integer>{
	List<Members> findByTeamid(int teamid);
	public Members findByName(String name);
	
}
