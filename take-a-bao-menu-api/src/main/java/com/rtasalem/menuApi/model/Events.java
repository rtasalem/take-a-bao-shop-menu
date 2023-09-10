package com.rtasalem.menuApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Events {
	
	@Id
	@SequenceGenerator(name = "EVENT_ID_GEN", sequenceName = "EVENT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_ID_GEN")
	private int eventId;
	
	@NotBlank(message = "Event title must not be left blank.")
	@Size(min = 5, max = 100, message = "Event title must be greater than 5 characters and less than 100 characters.")
	private String eventTitle;
	
	@NotBlank(message = "Event description must not be left blank.")
	@Size(min = 20, max = 10000, message = "Event description must be at least 20 characters.")
	private String eventDescription;
	
	@NotBlank(message = "Event image URL must not be left blank. Please provide the URL.")
	private String eventImage;

	public Events() {
		super();
	}

	public Events(String eventTitle, String eventDescription, String eventImage) {
		super();
		this.eventTitle = eventTitle;
		this.eventDescription = eventDescription;
		this.eventImage = eventImage;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventImage() {
		return eventImage;
	}

	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}

}
