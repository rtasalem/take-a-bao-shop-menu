package com.rtasalem.menuApi.service;

import org.springframework.stereotype.Service;

import com.rtasalem.menuApi.repository.EventsDAO;

@Service
public class EventsService {
	
	
	EventsDAO eventsRepo;
	
	// Constructor injection
	public EventsService(EventsDAO eventsRepo) {
		super();
		this.eventsRepo = eventsRepo;
	}
	
	

}
