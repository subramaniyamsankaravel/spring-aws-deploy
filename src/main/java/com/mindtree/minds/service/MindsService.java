package com.mindtree.minds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.minds.entity.Minds;
import com.mindtree.minds.entity.Track;
import com.mindtree.minds.exception.MindsServiceException;
import com.mindtree.minds.exception.ResourceNotFoundException;
import com.mindtree.minds.repo.MindsRepository;
import com.mindtree.minds.repo.TrackRepository;

@Service
public class MindsService {
	@Autowired
	MindsRepository mindsRepository;
	@Autowired
	TrackRepository trackRepository;

	public void save(Minds minds) {
		mindsRepository.save(minds);

	}

	public void save(Track track) {
		trackRepository.save(track);

	}

	public List<Minds> getAllMinds() {
		List<Minds> minds = new ArrayList<Minds>();
		mindsRepository.findAll().forEach(minds1 -> minds.add(minds1));
		return minds;
	}

	public List<Track> getAllTrack() {
		List<Track> track = new ArrayList<Track>();
		trackRepository.findAll().forEach(track1 -> track.add(track1));
		return track;
	}

	public List<Minds> getMindByTrackName(String trackName) throws ResourceNotFoundException {
		List<Minds> minds = new ArrayList<Minds>();

		try {
			minds = mindsRepository.findByTrackName(trackName);
			if (minds == null) {
				throw new ResourceNotFoundException("Track not found :" + trackName);
			}

		} catch (ResourceNotFoundException e) {
			throw new MindsServiceException(e);
		}
		return minds;
	}

	public Optional<Track> getTrackById(int trackId) throws ResourceNotFoundException {
		Optional<Track> track = null;
		try {
			track = trackRepository.findById(trackId);
			if (track == null) {

				throw new ResourceNotFoundException("Track not found");
			} else {
				return track;
			}

		} catch (ResourceNotFoundException e) {
			e.getStackTrace();
			throw new MindsServiceException(e);
		}

	}

	public Minds update(Minds newMind, Integer mindId) {
		return mindsRepository.findById(mindId).map(minds -> {
			minds.setMindName(newMind.getMindName());
			minds.setTrackName(newMind.getTrackName());
			minds.setRole(newMind.getRole());
			minds.setPhoneNumber(newMind.getPhoneNumber());
			return mindsRepository.save(minds);

		}).orElseGet(() -> {
			newMind.setMindId(mindId);
			return mindsRepository.save(newMind);
		});
	}

	public Track update(Track newTrack, Integer trackId) {
		return trackRepository.findById(trackId).map(track -> {
			track.setNo_Of_minds(newTrack.getNo_Of_minds());
			track.setTrackName(newTrack.getTrackName());
			return trackRepository.save(track);

		}).orElseGet(() -> {
			newTrack.setTrackId(trackId);
			return trackRepository.save(newTrack);
		});
	}

	public void deleteMindByID(Integer mindId) {
		mindsRepository.deleteById(mindId);

	}

	public void deleteTrackByID(Integer trackId) {
		trackRepository.deleteById(trackId);

	}

}
