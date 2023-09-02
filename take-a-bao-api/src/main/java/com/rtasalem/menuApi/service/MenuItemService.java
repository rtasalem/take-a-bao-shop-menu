package com.rtasalem.menuApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rtasalem.menuApi.exception.ItemNameExistsException;
import com.rtasalem.menuApi.exception.ResourceNotFoundException;
import com.rtasalem.menuApi.model.MenuItem;
import com.rtasalem.menuApi.repository.MenuItemDAO;

@Service
public class MenuItemService {

	private final MenuItemDAO menuItemRepo;

	public MenuItemService(MenuItemDAO menuItemRepo) {
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

	public List<MenuItem> findMenuItemByCategory(String itemCategory) {
		return menuItemRepo.findByItemCategoryContainsIgnoreCase(itemCategory);
	}

	public MenuItem createMenuItem(MenuItem menuItem) {

		if (menuItemRepo.existsByItemName(menuItem.getItemName())) {
			throw new ItemNameExistsException(
					"A menu item with the name of " + menuItem.getItemName() + " already exists.");
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

	public List<MenuItem> findMenuItemsByNameOrDescriptionOrCategory(String searchTerm) {
		return menuItemRepo
				.findByItemNameContainsIgnoreCaseOrItemDescriptionContainsIgnoreCaseOrItemCategoryContainsIgnoreCase(
						searchTerm, searchTerm, searchTerm);
	}

}
