package com.rtasalem.menuApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtasalem.menuApi.model.MenuItem;

public interface MenuItemDAO extends JpaRepository<MenuItem, Integer> {

	boolean existsByItemName(String itemName);

	boolean existsByItemImage(String itemImage);

	List<MenuItem> findByItemCategoryContainsIgnoreCase(String itemCategory);

	List<MenuItem> findByItemNameContainsIgnoreCaseOrItemDescriptionContainsIgnoreCaseOrItemCategoryContainsIgnoreCase(
			String itemName, String itemDescription, String itemCategory);

}
