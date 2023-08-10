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
	@Size(min = 10, max = 150, message = "Menu item description must be greater than 10 characters and less than 150 characters.")
	private String itemDescription;

	@DecimalMax(value = "20.00", message = "Menu item price must be less than £20.00 (GBP).")
	@DecimalMin(value = "1.50", message = "Menu item price must be greater than £1.50 (GBP).")
	private double itemPrice;

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

	public boolean isSuitableForVegetarians() {
		return suitableForVegetarians;
	}

	public void setSuitableForVegetarians(boolean suitableForVegetarians) {
		this.suitableForVegetarians = suitableForVegetarians;
	}

}
