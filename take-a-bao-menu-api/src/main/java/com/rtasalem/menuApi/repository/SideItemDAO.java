package com.rtasalem.menuApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtasalem.menuApi.model.SideItem;

public interface SideItemDAO extends JpaRepository<SideItem, Integer> {

	boolean existsBySideName(String sideName);

	List<SideItem> findBySideNameContainsIgnoreCaseOrSideDescriptionContainsIgnoreCase(String sideName,
			String sideDescription);

}
