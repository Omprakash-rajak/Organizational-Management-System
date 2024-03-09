package com.test.demoTest.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.demoTest.entity.Members;
import com.test.demoTest.entity.Teams;

public interface TeamRepository extends JpaRepository<Teams, Integer> {
	
	//List<Members> findById(int id);
	
}
