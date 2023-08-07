package com.rtasalem.menuApi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.rtasalem.menuApi.service.MenuItemService;

@WebMvcTest(MenuItemController.class)
class MenuItemControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MenuItemService menuItemService;

	@Test
	void testGetAllMenuItems_ReturnsListOfMenuItems() throws Exception {
		mockMvc.perform(get("/menu-items").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
