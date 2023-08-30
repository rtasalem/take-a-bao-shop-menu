package com.rtasalem.menuApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class MenuItem {

	@Id
	@SequenceGenerator(name = "ITEM_ID_GEN", sequenceName = "ITEM_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_ID_GEN")
	private int itemId;

	@NotBlank(message = "Menu item name must not be left blank.")
	@Size(min = 2, max = 25, message = "Menu item name must be greater than 2 characters and less than 25 characters.")
	private String itemName;

	@NotBlank(message = "Menu item description must not be left blank.")
	@Size(min = 10, max = 500, message = "Menu item description must be greater than 10 characters and less than 500 characters.")
	private String itemDescription;

	@DecimalMax(value = "20.00", message = "Menu item price must be less than £20.00 (GBP).")
	@DecimalMin(value = "1.00", message = "Menu item price must be greater than £1.00 (GBP).")
	private double itemPrice;

	@NotBlank(message = "Menu item category must not be left blank. One of the following categories must be listed: main, side, dessert, or drink.")
	private String itemCategory;

	@NotBlank(message = "Menu item image URL must not be left blank.")
	private String itemImage;

	private boolean suitableForVegetarians;

	public MenuItem() {
		super();
	}

	public MenuItem(String itemName, String itemDescription, double itemPrice, boolean suitableForVegetarians) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.suitableForVegetarians = suitableForVegetarians;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public boolean isSuitableForVegetarians() {
		return suitableForVegetarians;
	}

	public void setSuitableForVegetarians(boolean suitableForVegetarians) {
		this.suitableForVegetarians = suitableForVegetarians;
	}

}