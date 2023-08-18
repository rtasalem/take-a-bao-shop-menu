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
public class SideItem {

	@Id
	@SequenceGenerator(name = "SIDE_ID_GEN", sequenceName = "SIDE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIDE_ID_GEN")
	private int sideId;

	@NotBlank(message = "Side item name must not be left blank.")
	@Size(min = 2, max = 25, message = "Side item name must be greater than 2 characters and less than 10 characters.")
	private String sideName;

	@NotBlank(message = "Side item description must not be left blank.")
	@Size(min = 10, max = 150, message = "Side item description must be greater than 10 characters and less than 150 characters.")
	private String sideDescription;

	@DecimalMax(value = "5.00", message = "Side item price must be less than £5.00 (GBP).")
	@DecimalMin(value = "1.00", message = "Side item price must be greater than £1.00 (GBP).")
	private double sidePrice;

	private boolean suitableForVegetarians;

	public SideItem() {
		super();
	}

	public SideItem(String sideName, String sideDescription, double sidePrice, boolean suitableForVegetarians) {
		super();
		this.sideName = sideName;
		this.sideDescription = sideDescription;
		this.sidePrice = sidePrice;
		this.suitableForVegetarians = suitableForVegetarians;
	}

	public int getSideId() {
		return sideId;
	}

	public void setSideId(int sideId) {
		this.sideId = sideId;
	}

	public String getSideName() {
		return sideName;
	}

	public void setSideName(String sideName) {
		this.sideName = sideName;
	}

	public String getSideDescription() {
		return sideDescription;
	}

	public void setSideDescription(String sideDescription) {
		this.sideDescription = sideDescription;
	}

	public double getSidePrice() {
		return sidePrice;
	}

	public void setSidePrice(double sidePrice) {
		this.sidePrice = sidePrice;
	}

	public boolean isSuitableForVegetarians() {
		return suitableForVegetarians;
	}

	public void setSuitableForVegetarians(boolean suitableForVegetarians) {
		this.suitableForVegetarians = suitableForVegetarians;
	}

}
