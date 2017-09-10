package com.lastminuteTest.taxRate;

/**
 * Abstract class that represent the basic rate tax 
 * 
 * @author fabio
 *
 */
public abstract class TaxesType {

	float baseRateTax = 0;
		
	public TaxesType(float baseRateTax) {
		
		this.baseRateTax = baseRateTax;
	}

	public float getBaseRateTax() {
		return baseRateTax;
	}

	public void setBaseRateTax(float baseRateTax) {
		this.baseRateTax = baseRateTax;
	}

}
