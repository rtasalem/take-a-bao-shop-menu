package com.rtasalem.menuApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rtasalem.menuApi.exception.ItemNameExistsException;
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
			throw new ResourceNotFoundException("Menu item with an ID of " + itemId + " does not exist.");
		}
		return menuItemOpt.get();
	}

	public MenuItem createMenuItem(MenuItem menuItem) {

		if (menuItemRepo.existsByItemName(menuItem.getItemName())) {
			throw new ItemNameExistsException(
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

	public MenuItem editMenuItem(MenuItem menuItem, int itemId) {

		if (!menuItemRepo.existsById(itemId)) {
			throw new ResourceNotFoundException("Menu item with ID of " + itemId + " does not exist.");
		}
		menuItem.setItemId(itemId);
		return menuItemRepo.save(menuItem);
	}

	public void removeMenuItemById(int itemId) {

		if (!menuItemRepo.existsById(itemId)) {
			throw new ResourceNotFoundException("Menu item with ID of " + itemId + " does not exist.");
		}
		menuItemRepo.deleteById(itemId);
	}

	public List<MenuItem> findMenuItemsByNameOrDescription(String searchTerm) {
		return menuItemRepo.findByItemNameContainsIgnoreCaseOrItemDescriptionContainsIgnoreCase(searchTerm, searchTerm);
	}

}
