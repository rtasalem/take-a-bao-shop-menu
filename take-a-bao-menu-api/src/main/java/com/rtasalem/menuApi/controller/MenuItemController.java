package com.rtasalem.menuApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rtasalem.menuApi.model.MenuItem;
import com.rtasalem.menuApi.service.MenuItemService;

@RestController
@RequestMapping("/api/v1/menu-items")
@CrossOrigin(origins = "http://localhost:3000")
public class MenuItemController {

	private final MenuItemService menuItemService;

	@Autowired
	public MenuItemController(MenuItemService menuItemService) {
		super();
		this.menuItemService = menuItemService;
	}

	@GetMapping
	public ResponseEntity<List<MenuItem>> getAllMenuItems() {
		return ResponseEntity.status(HttpStatus.OK).body(menuItemService.findAllMenuItems());
	}

}
