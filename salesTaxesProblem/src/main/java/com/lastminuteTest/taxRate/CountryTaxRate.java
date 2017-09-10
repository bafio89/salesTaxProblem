package com.lastminuteTest.taxRate;

import com.lastminuteTest.product.Product;
import com.lastminuteTest.taxCalculator.TaxCalculatorStrategyInterface;

/**
 * This class aggragates necessary infos to calculate taxes.
 * 
 * @author fabio
 *
 */
public class CountryTaxRate implements CountryTaxRateInterface{
	
	String countryPrefix;
	
	StandardTaxesType standardTaxesType;
	
	TaxCalculatorStrategyInterface taxCalculatorStrategy;
	
	public CountryTaxRate(String countryPrefix, StandardTaxesType baseTaxesType) {

		this.countryPrefix = countryPrefix;
		this.standardTaxesType = baseTaxesType;		
	}

	public String getCountryPrefix() {
		return countryPrefix;
	}
	
	public void setCountryPrefix(String countryPrefix) {
		this.countryPrefix = countryPrefix;
	}
		
	public TaxCalculatorStrategyInterface getTaxCalculatorStrategy() {
		return taxCalculatorStrategy;
	}
	
	public void setTaxCalculatorStrategy(TaxCalculatorStrategyInterface taxCalculator) {
		this.taxCalculatorStrategy = taxCalculator;
	}
	
	public float calculateTax(Product product){
		return taxCalculatorStrategy.calculateTaxes(standardTaxesType, product);
	}

}
