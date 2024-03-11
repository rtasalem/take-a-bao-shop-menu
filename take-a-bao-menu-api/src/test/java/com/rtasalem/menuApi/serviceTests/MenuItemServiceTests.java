package com.rtasalem.menuApi.serviceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rtasalem.menuApi.exception.ItemNameExistsException;
import com.rtasalem.menuApi.exception.ResourceNotFoundException;
import com.rtasalem.menuApi.model.MenuItem;
import com.rtasalem.menuApi.repository.MenuItemDAO;
import com.rtasalem.menuApi.service.MenuItemService;

@ExtendWith(MockitoExtension.class)
class MenuItemServiceTests {

	@Mock
	private MenuItemDAO mockMenuItemRepo;

	@InjectMocks
	private MenuItemService mockMenuItemService;

	@Test
	public void testFindAllMenuItems_ReturnsListOfMenuItems() {
		// Arrange
		List<MenuItem> items = new ArrayList<MenuItem>();
		when(mockMenuItemRepo.findAll()).thenReturn(items);
		
		// Act
		List<MenuItem> result = mockMenuItemService.findAllMenuItems();
		
		// Assert
		assertEquals(items, result);
		verify(mockMenuItemRepo).findAll();
	}
	
	@Test
	public void testFindMenuItemsByItemId_ReturnsMenuItem_WhenItemExists() {
		// Arrange 
		int itemId = 1;
		MenuItem newMenuItem = new MenuItem();
		when(mockMenuItemRepo.findById(itemId)).thenReturn(Optional.of(newMenuItem));
		
		// Act
		MenuItem result = mockMenuItemService.findMenuItemById(itemId);
		
		// Assert
		assertEquals(newMenuItem, result);
		verify(mockMenuItemRepo).findById(itemId);
	}
	
	@Test
	public void testFindMenuItemsByItemId_ThrowsResourceNotFoundException_WhenItemDoesNotExist() {
		// Arrange
		int itemId = 1;
		when(mockMenuItemRepo.findById(itemId)).thenReturn(Optional.empty());
		
		// Act & Assert
		assertThrows(ResourceNotFoundException.class, () -> mockMenuItemService.findMenuItemById(itemId));
		verify(mockMenuItemRepo).findById(itemId);
	}
	
	@Test
	public void testCreateNewMenuItem_CreatesItem_WhenValidData() {
		// Arrange 
		MenuItem newMenuItem = new MenuItem();
		newMenuItem.setItemName("Gochujang Tofu");
		newMenuItem.setItemDescription("Spicy and flavourful");
		when(mockMenuItemRepo.existsByItemName(newMenuItem.getItemName())).thenReturn(false);
		when(mockMenuItemRepo.save(newMenuItem)).thenReturn(newMenuItem);
		
		// Act
		MenuItem result = mockMenuItemService.createMenuItem(newMenuItem);
		
		// Assert
		assertEquals(newMenuItem, result);
		verify(mockMenuItemRepo).save(newMenuItem);
	}
	
	@Test
	public void testCreateNewMenuItem_ThrowsItemNameExistsException_WhenItemNameExists() {
		// Arrange
		MenuItem newMenuItem = new MenuItem();
		newMenuItem.setItemName("Gochujang Tofu");
		when(mockMenuItemRepo.existsByItemName(newMenuItem.getItemName())).thenReturn(true);
		
		// Act & Assert
		assertThrows(ItemNameExistsException.class, () -> mockMenuItemService.createMenuItem(newMenuItem));
		verify(mockMenuItemRepo, never()).save(newMenuItem);
	}
	
	@Test
	public void testEditmenuItem_UpdatesMenuItem_WhenValidData() {
		// Arrange
		int itemId = 1;
		MenuItem menuItem = new MenuItem();
		menuItem.setItemId(itemId);
		when(mockMenuItemRepo.existsById(itemId)).thenReturn(true);
		when(mockMenuItemRepo.save(menuItem)).thenReturn(menuItem);
		
		// Act
		MenuItem result = mockMenuItemService.editMenuItem(menuItem, itemId);
		
		// Assert 
		assertEquals(menuItem, result);
		verify(mockMenuItemRepo).save(menuItem);
	}
	
	@Test
	public void testEditExistingMenuItem_ThrowsResourceNotFoundException_WhenMenuItemDoesNotExist() {
		// Arrange 
		int itemId = 1;
		MenuItem menuItem = new MenuItem();
		when(mockMenuItemRepo.existsById(itemId)).thenReturn(false);
		
		// Act & Assert
		assertThrows(ResourceNotFoundException.class, () -> mockMenuItemService.editMenuItem(menuItem, itemId));
		verify(mockMenuItemRepo, never()).save(menuItem);
	}
	
	@Test
	public void testRemoveMenuItemByItemId_RemovesMenuItem_WhenMenuItemExists() {
		// Arrange
		int itemId = 1;
		when(mockMenuItemRepo.existsById(itemId)).thenReturn(true);
		
		// Act
		mockMenuItemService.removeMenuItemById(itemId);
		
		// Assert
		verify(mockMenuItemRepo).deleteById(itemId); 
	}
	
	@Test
	public void testRemoveMenuItemByItemId_ThrowsResourceNotFoundException_WhenMenuItemDoesNotExist() {
		// Arrange
		int itemId = 1;
		when(mockMenuItemRepo.existsById(itemId)).thenReturn(false);
		
		// Act
		assertThrows(ResourceNotFoundException.class, () -> mockMenuItemService.removeMenuItemById(itemId));
		verify(mockMenuItemRepo, never()).deleteById(itemId);
	}

}
