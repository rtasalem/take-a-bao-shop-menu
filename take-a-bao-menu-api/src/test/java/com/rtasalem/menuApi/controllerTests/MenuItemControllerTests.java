package com.rtasalem.menuApi.controllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.rtasalem.menuApi.controller.MenuItemController;
import com.rtasalem.menuApi.model.MenuItem;
import com.rtasalem.menuApi.service.MenuItemService;

@ExtendWith(MockitoExtension.class)
class MenuItemControllerTests {

	private MockMvc mockMvc;

	@Mock
	private MenuItemService mockMenuItemService;

	@InjectMocks
	private MenuItemController mockMenuItemController;

	private MenuItem createMenuItem(int itemId) {
		MenuItem menuItem = new MenuItem();
		menuItem.setItemId(itemId);
		return menuItem;
	}

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(mockMenuItemController).build();
	}

	@Test
	public void testGetAllMenuItems_ReturnsListOfMenuItemsAndOkResponse() {
		// Arrange
		MenuItem item1 = createMenuItem(1);
		MenuItem item2 = createMenuItem(2);
		List<MenuItem> menuItems = Arrays.asList(item1, item2);
		when(mockMenuItemService.findAllMenuItems()).thenReturn(menuItems);
		
		// Act
		ResponseEntity<List<MenuItem>> response = mockMenuItemController.getAllMenuItems();
		
		// Arrange
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(menuItems, response.getBody());
		verify(mockMenuItemService, times(1)).findAllMenuItems();
	}

	@Test
	public void testGetMenuItemByItemId_ReturnsMenuItemAndOkResponse() {
		// Arrange
		int itemId = 1;
		MenuItem item = createMenuItem(itemId);
		when(mockMenuItemService.findMenuItemById(itemId)).thenReturn(item);
		
		// Act
		ResponseEntity<MenuItem> response = mockMenuItemController.getMenuItemById(itemId);
		
		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(item, response.getBody());
		verify(mockMenuItemService, times(1)).findMenuItemById(itemId);
	}
	
	@Test
	public void testAddNewMenuItem_CreatesNewMenuItemSuccessfully() throws Exception {
		// Arrange
		MenuItem item = new MenuItem("Char Siu Bao", "Very tasty choice", 1.99, "main","url-for-menu-item-image", false);
		ArgumentCaptor<MenuItem> captor = ArgumentCaptor.forClass(MenuItem.class);
		when(mockMenuItemService.createMenuItem(captor.capture())).thenReturn(item);
		
		// Act
		mockMvc.perform(post("/api/v1/menu-items").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(item)))
		// Assert
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.itemName").value("Char Siu Bao"))
		.andExpect(jsonPath("$.itemDescription").value("Very tasty choice"))
		.andExpect(jsonPath("$.itemPrice").value("1.99"))
		.andExpect(jsonPath("$.itemCategory").value("main"))
		.andExpect(jsonPath("$.itemImage").value("url-for-menu-item-image"))
		.andExpect(jsonPath("$.suitableForVegetarians").value("false"));
		
		verify(mockMenuItemService, times(1)).createMenuItem(captor.getValue());
	}
	
	@Test
	public void testUpdateMenuItem_UpdatesMenuItemSuccessfully() {
		// Arrange
		int itemId = 1;
		MenuItem updatedMenuItem = createMenuItem(itemId);
		when(mockMenuItemService.editMenuItem(any(), eq(itemId))).thenReturn(updatedMenuItem);
		
		// Act
		ResponseEntity<MenuItem> response = mockMenuItemController.updateMenuItem(itemId, updatedMenuItem);
		
		// Assert 
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(updatedMenuItem, response.getBody());
		verify(mockMenuItemService, times(1)).editMenuItem(updatedMenuItem, itemId);
	}
	
	@Test
	public void testDeleteMenuItemByItemId_DeletesMenuItemSuccessfully() {
		// Arrange
		int itemId = 1;
		
		// Act
		ResponseEntity<Void> response = mockMenuItemController.deleteMenuItem(itemId);
		
		// Assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNull(response.getBody());
		verify(mockMenuItemService, times(1)).removeMenuItemById(itemId);
	}
}
