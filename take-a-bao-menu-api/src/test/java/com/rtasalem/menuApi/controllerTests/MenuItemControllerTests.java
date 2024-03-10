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
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.rtasalem.menuApi.model.MenuItem;
import com.rtasalem.menuApi.controller.MenuItemController;
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
		mockMvc = MockMvcBuilders.standaloneSetup(menuItemController).build();
	}

	@Test
	public void testGetAllMenuItems_ReturnsListOfMenuItemsAndOkResponse() {
		// Arrange
		MenuItem item1 = createMenuItem(1);
		MenuItem item2 = createMenuItem(2);
		List<MenuItem> menuItems = new Arrays.asList(item1, item2);
		when(mockMenuItemService.findAllMenuItems()).thenReturn(menuItems);

		// Act
		ResponseEntity<List<MenuItem>> response = mockMenuItemController.getAllMenuItems();

		// Assert
		assertEquals(HttpStaus.OK, response.getStatusCode());
		assertEquals(menuItems, response.getBody());
		verify(mockMenuItemService, times(1)).findAllMenuItems();
	}


}
