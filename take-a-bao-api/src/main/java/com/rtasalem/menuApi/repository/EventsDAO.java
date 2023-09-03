package com.rtasalem.menuApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtasalem.menuApi.model.Events;

public interface EventsDAO extends JpaRepository<Events, Integer> {

}
