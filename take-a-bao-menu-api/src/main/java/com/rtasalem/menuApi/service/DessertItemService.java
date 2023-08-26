package com.rtasalem.menuApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rtasalem.menuApi.exception.ResourceNotFoundException;
import com.rtasalem.menuApi.model.DessertItem;
import com.rtasalem.menuApi.repository.DessertItemDAO;

@Service
public class DessertItemService {

	private final DessertItemDAO dessertItemRepo;

	public DessertItemService(DessertItemDAO dessertItemRepo) {
		super();
		this.dessertItemRepo = dessertItemRepo;
	}

	public List<DessertItem> findAllDessertItems() {
		return dessertItemRepo.findAll();
	}

	public DessertItem findDessertItemById(int dessertId) {
		Optional<DessertItem> dessertItemOpt = dessertItemRepo.findById(dessertId);
		if (dessertItemOpt.isEmpty()) {
			throw new ResourceNotFoundException("Dessert item with ID of " + dessertId + " does not exist.");
		}
		return dessertItemOpt.get();
	}

}
