package com.rtasalem.menuApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
