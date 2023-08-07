package com.rtasalem.menuApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtasalem.menuApi.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
