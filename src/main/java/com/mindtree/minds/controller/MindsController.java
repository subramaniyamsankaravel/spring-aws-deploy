package com.mindtree.minds.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.minds.entity.Minds;
import com.mindtree.minds.entity.Track;
import com.mindtree.minds.exception.MindsServiceException;
import com.mindtree.minds.exception.ResourceNotFoundException;
import com.mindtree.minds.service.MindsService;

@RestController
@RequestMapping(path = "/api/minds")
public class MindsController {
	@Autowired
	MindsService mindsService;

	@PostMapping("/minds")
	private HttpStatus saveMinds(@RequestBody Minds minds) {
		mindsService.save(minds);
		return HttpStatus.CREATED;
	}

	@PostMapping("/track")
	private HttpStatus saveTrack(@RequestBody Track track) {
		mindsService.save(track);
		return HttpStatus.CREATED;
	}

	@GetMapping("/getAllMinds")
	private List<Minds> getAllMinds() {
		return mindsService.getAllMinds();
	}

	@GetMapping("/getAllTrack")
	private List<Track> getAllTrack() {
		return mindsService.getAllTrack();
	}

	@GetMapping("/minds/{trackName}")
	private ResponseEntity<?> getMind(@PathVariable("trackName") String trackName) throws ResourceNotFoundException {
		List<Minds> mind = null;
		String s = null;
		try {
			mind = mindsService.getMindByTrackName(trackName);
			return new ResponseEntity<>(mind, HttpStatus.OK);
		} catch (MindsServiceException e) {
			System.out.println(e.getLocalizedMessage());
			s = e + "error";
			return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("/track/{trackId}")
	private ResponseEntity<?> getTrack(@PathVariable("trackId") int trackId) throws ResourceNotFoundException {
		Optional<Track> track = null;
		String s = null;
		try {
			track = mindsService.getTrackById(trackId);
			return new ResponseEntity<>(track, HttpStatus.OK);
		} catch (MindsServiceException e) {
			System.out.println(e.getLocalizedMessage());
			s = e + "error";
		}
		return new ResponseEntity<>(s, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/minds/{mindId}")
	private Minds updateMind(@RequestBody Minds newMind, @PathVariable Integer mindId) {
		Minds mind = mindsService.update(newMind, mindId);
		return mind;
	}

	@PutMapping("/track/{trackId}")
	private Track updateTrack(@RequestBody Track newTrack, @PathVariable Integer trackId) {
		Track track = mindsService.update(newTrack, trackId);
		return track;
	}

	@DeleteMapping("/deleteMind/{mindId}")
	HttpStatus deleteMind(@PathVariable Integer mindId) {
		mindsService.deleteMindByID(mindId);
		return HttpStatus.OK;

	}

	@DeleteMapping("/deleteTrack/{trackId}")
	HttpStatus deleteTrack(@PathVariable Integer trackId) {
		mindsService.deleteTrackByID(trackId);
		return HttpStatus.OK;

	}
}
