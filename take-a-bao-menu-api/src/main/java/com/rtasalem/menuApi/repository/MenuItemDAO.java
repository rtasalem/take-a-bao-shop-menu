package com.rtasalem.menuApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtasalem.menuApi.model.MenuItem;

public interface MenuItemDAO extends JpaRepository<MenuItem, Integer> {

	boolean existsByItemName(String itemName);

	List<MenuItem> findByItemCategoryContainsIgnoreCase(String itemCategory);

	List<MenuItem> findByItemNameContainsIgnoreCaseOrItemDescriptionContainsIgnoreCase(String itemName,
			String itemDescription);

}
