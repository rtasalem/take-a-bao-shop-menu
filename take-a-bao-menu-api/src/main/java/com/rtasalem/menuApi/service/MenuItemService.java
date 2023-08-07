package com.rtasalem.menuApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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

}
