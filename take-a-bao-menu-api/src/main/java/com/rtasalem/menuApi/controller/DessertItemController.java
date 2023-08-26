package com.rtasalem.menuApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rtasalem.menuApi.model.DessertItem;
import com.rtasalem.menuApi.service.DessertItemService;

@RestController
@RequestMapping("/api/v1/dessert-items")
@CrossOrigin(origins = "http://localhost:3000")
public class DessertItemController {

	private final DessertItemService dessertItemService;

	public DessertItemController(DessertItemService dessertItemService) {
		super();
		this.dessertItemService = dessertItemService;
	}

	@GetMapping
	public ResponseEntity<List<DessertItem>> getAllDessertItems() {
		return ResponseEntity.status(HttpStatus.OK).body(dessertItemService.findAllDessertItems());
	}

	@GetMapping("/{dessertId}")
	public ResponseEntity<DessertItem> getDessertItemById(int dessertId) {
		return ResponseEntity.status(HttpStatus.OK).body(dessertItemService.findDessertItemById(dessertId));
	}

}
