package com.rtasalem.menuApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rtasalem.menuApi.exception.MenuItemNameExistsException;
import com.rtasalem.menuApi.exception.ResourceNotFoundException;
import com.rtasalem.menuApi.model.MenuItem;
import com.rtasalem.menuApi.repository.MenuItemRepository;

@Service
public class MenuItemService {

	private final MenuItemRepository menuItemRepo;

	public MenuItemService(MenuItemRepository menuItemRepo) {
		super();
		this.menuItemRepo = menuItemRepo;
	}

	public List<MenuItem> findAllMenuItems() {
		return menuItemRepo.findAll();
	}

	public MenuItem findMenuItemById(int itemId) {

		Optional<MenuItem> menuItemOpt = menuItemRepo.findById(itemId);
		if (menuItemOpt.isEmpty()) {
			throw new ResourceNotFoundException("Menu item with an ID of " + itemId + " not found in the database.");
		}
		return menuItemOpt.get();
	}

	public MenuItem createMenuItem(MenuItem menuItem) {

		if (menuItemRepo.existsByItemName(menuItem.getItemName())) {
			throw new MenuItemNameExistsException(
					"A menu item with the name of " + menuItem.getItemName() + " already exists.");
		}
		if (menuItem.getItemName().isBlank() || menuItem.getItemName().isEmpty()) {
			throw new RuntimeException("Menu item name must not be left blank.");
		}
		if (menuItem.getItemDescription().isBlank() || menuItem.getItemDescription().isEmpty()) {
			throw new RuntimeException("Menu item description must not be left blank.");
		}
		return menuItemRepo.save(menuItem);
	}

}
