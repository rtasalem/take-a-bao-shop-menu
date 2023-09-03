package com.rtasalem.menuApi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rtasalem.menuApi.service.EventsService;

@RestController
@RequestMapping("/api/v1/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventsController {
	
	EventsService eventsService;

	// Using constructor injection
	public EventsController(EventsService eventsService) {
		super();
		this.eventsService = eventsService;
	}

	
	
	

}
