package com.rtasalem.menuApi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rtasalem.menuApi.model.Events;
import com.rtasalem.menuApi.service.EventsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventsController {
	
	EventsService eventsService;

	// Constructor injection
	public EventsController(EventsService eventsService) {
		super();
		this.eventsService = eventsService;
	}

	@GetMapping
	public ResponseEntity<List<Events>> getAllEvents() {
		return ResponseEntity.status(HttpStatus.OK).body(eventsService.findAllEvents());
	}
	
	@PostMapping
	public ResponseEntity<Events> addNewEvent(@Valid @RequestBody Events event) {
		eventsService.createEvent(event);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{eventId}").buildAndExpand(event.getEventId()).toUri();
		return ResponseEntity.created(location).body(event);
	}
	
	@PutMapping("/{eventId}")
	public ResponseEntity<Events> updateEvent(@PathVariable int eventId, @Valid @RequestBody Events event) {
		return ResponseEntity.ok(eventsService.editEvent(event, eventId));
	}
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<Void> deleteEvent(@PathVariable int eventId) {
		eventsService.removeEventByEventId(eventId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	

}
