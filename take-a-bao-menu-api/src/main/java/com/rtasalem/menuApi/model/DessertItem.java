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
public class DessertItem {

	@Id
	@SequenceGenerator(name = "DESSERT_ID_GEN", sequenceName = "DESSERT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESSERT_ID_GEN")
	private int dessertId;

	@NotBlank(message = "Dessert item name must not be left blank.")
	@Size(min = 2, max = 25, message = "Dessert item name must be greater than 2 characters and less than 25 characters.")
	private String dessertName;

	@NotBlank(message = "Dessert item description must not be left blank.")
	@Size(min = 10, max = 500, message = "Dessert item description must be greater than 10 characters and less than 500 characters.")
	private String dessertDescription;

	@DecimalMax(value = "20.00", message = "Dessert item price must be less than £20.00 (GBP).")
	@DecimalMin(value = "1.00", message = "Dessert item price must be greater than £1.00 (GBP).")
	private double dessertPrice;

	private boolean suitableForVegetarians;

	public DessertItem() {
		super();
	}

	public DessertItem(String dessertName, String dessertDescription, double dessertPrice,
			boolean suitableForVegetarians) {
		super();
		this.dessertName = dessertName;
		this.dessertDescription = dessertDescription;
		this.dessertPrice = dessertPrice;
		this.suitableForVegetarians = suitableForVegetarians;
	}

	public int getDessertId() {
		return dessertId;
	}

	public void setDessertId(int dessertId) {
		this.dessertId = dessertId;
	}

	public String getDessertName() {
		return dessertName;
	}

	public void setDessertName(String dessertName) {
		this.dessertName = dessertName;
	}

	public String getDessertDescription() {
		return dessertDescription;
	}

	public void setDessertDescription(String dessertDescription) {
		this.dessertDescription = dessertDescription;
	}

	public double getDessertPrice() {
		return dessertPrice;
	}

	public void setDessertPrice(double dessertPrice) {
		this.dessertPrice = dessertPrice;
	}

	public boolean isSuitableForVegetarians() {
		return suitableForVegetarians;
	}

	public void setSuitableForVegetarians(boolean suitableForVegetarians) {
		this.suitableForVegetarians = suitableForVegetarians;
	}

}
