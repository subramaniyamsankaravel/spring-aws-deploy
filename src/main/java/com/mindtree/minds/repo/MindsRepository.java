package com.mindtree.minds.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.minds.entity.Minds;

public interface MindsRepository extends JpaRepository<Minds, Integer> {

	List<Minds> findByTrackName(String trackName);
	
}
