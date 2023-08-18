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
public class DrinkItem {

	@Id
	@SequenceGenerator(name = "DRINK_ID_GEN", sequenceName = "DRINK_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DRINK_ID_GEN")
	private int drinkId;

	@NotBlank(message = "Drink item name must not be left blank.")
	@Size(min = 2, max = 25, message = "Drink item name must be greater than 2 characters and less than 25 characters.")
	private String drinkName;

	@NotBlank(message = "Drink item description must not be left blank.")
	@Size(min = 10, max = 150, message = "Drink item description must be greater than 10 characters and less than 150 characters.")
	private String drinkDescription;

	@DecimalMax(value = "5.00", message = "Drink item price must be less than £5.00 (GBP).")
	@DecimalMin(value = "1.00", message = "Drink item price must be greater than £1.00 (GBP).")
	private double drinkPrice;

	private boolean suitableForVegetarians;

	public DrinkItem() {
		super();
	}

	public DrinkItem(String drinkName, String drinkDescription, double drinkPrice, boolean suitableForVegetarians) {
		super();
		this.drinkName = drinkName;
		this.drinkDescription = drinkDescription;
		this.drinkPrice = drinkPrice;
		this.suitableForVegetarians = suitableForVegetarians;
	}

	public int getDrinkId() {
		return drinkId;
	}

	public void setDrinkId(int drinkId) {
		this.drinkId = drinkId;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public String getDrinkDescription() {
		return drinkDescription;
	}

	public void setDrinkDescription(String drinkDescription) {
		this.drinkDescription = drinkDescription;
	}

	public double getDrinkPrice() {
		return drinkPrice;
	}

	public void setDrinkPrice(double drinkPrice) {
		this.drinkPrice = drinkPrice;
	}

	public boolean isSuitableForVegetarians() {
		return suitableForVegetarians;
	}

	public void setSuitableForVegetarians(boolean suitableForVegetarians) {
		this.suitableForVegetarians = suitableForVegetarians;
	}

}
