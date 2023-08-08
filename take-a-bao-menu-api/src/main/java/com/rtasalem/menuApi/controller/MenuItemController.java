package com.rtasalem.menuApi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rtasalem.menuApi.model.MenuItem;
import com.rtasalem.menuApi.service.MenuItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/menu-items")
@CrossOrigin(origins = "http://localhost:3000")
public class MenuItemController {

	private final MenuItemService menuItemService;

	public MenuItemController(MenuItemService menuItemService) {
		super();
		this.menuItemService = menuItemService;
	}

	@GetMapping
	public ResponseEntity<List<MenuItem>> getAllMenuItems() {
		return ResponseEntity.status(HttpStatus.OK).body(menuItemService.findAllMenuItems());
	}

	@GetMapping("/{itemId}")
	public ResponseEntity<MenuItem> getMenuItemById(@PathVariable int itemId) {
		return ResponseEntity.status(HttpStatus.OK).body(menuItemService.findMenuItemById(itemId));
	}

	@PostMapping
	public ResponseEntity<MenuItem> addNewMenuItem(@Valid @RequestBody MenuItem menuItem) {
		menuItemService.createMenuItem(menuItem);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(menuItem.getItemId()).toUri();
		return ResponseEntity.created(location).body(menuItem);
	}

}
