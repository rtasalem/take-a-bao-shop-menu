package com.rtasalem.menuApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtasalem.menuApi.model.DessertItem;

public interface DessertItemDAO extends JpaRepository<DessertItem, Integer> {

	boolean existsByDessertName(String dessertName);

	List<DessertItem> findByDessertNameContainsIgnoreCaseOrDessertDescriptionContainsIgnoreCase(String dessertName,
			String dessertDescription);

}
