package com.rtasalem.menuApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rtasalem.menuApi.exception.ResourceNotFoundException;
import com.rtasalem.menuApi.model.Events;
import com.rtasalem.menuApi.repository.EventsDAO;

@Service
public class EventsService {
	
	
	EventsDAO eventsRepo;
	
	// Constructor injection
	public EventsService(EventsDAO eventsRepo) {
		super();
		this.eventsRepo = eventsRepo;
	}

	public List<Events> findAllEvents() {
		return eventsRepo.findAll();
	}
	
	public Events findEventById(int eventId) {
		
		Optional<Events> eventOpt = eventsRepo.findById(eventId);
		if (eventOpt.isEmpty()) {
			throw new ResourceNotFoundException("Event with ID of " + eventId + " does not exist.");
		}
		return eventOpt.get();
	}
	
	public Events createEvent(Events event) {
		return eventsRepo.save(event);
	}
	
	public Events editEvent(Events event, int eventId) {
		
		if (!eventsRepo.existsById(eventId)) {
			throw new ResourceNotFoundException("Event with ID of " + eventId + " does not exist.");
		}
		event.setEventId(eventId);
		return eventsRepo.save(event);
	}
	
	public void removeEventByEventId(int eventId) {
		
		if (!eventsRepo.existsById(eventId)) {
			throw new ResourceNotFoundException("Event with ID of " + eventId + " does not exist.");
		}
		eventsRepo.deleteById(eventId);
	}

}
