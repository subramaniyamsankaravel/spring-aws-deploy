package com.mindtree.minds.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.minds.entity.Track;

public interface TrackRepository extends JpaRepository<Track, Integer> {

	void deleteById(Integer trackId);

}
