package com.rtasalem.menuApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtasalem.menuApi.model.DrinkItem;

public interface DrinkItemDAO extends JpaRepository<DrinkItem, Integer> {

	boolean existsByDrinkName(String drinkName);

	List<DrinkItem> findByDrinkNameContainsIgnoreCaseOrDrinkDescriptionContainsIgnoreCase(String drinkName,
			String drinkDescription);

}
