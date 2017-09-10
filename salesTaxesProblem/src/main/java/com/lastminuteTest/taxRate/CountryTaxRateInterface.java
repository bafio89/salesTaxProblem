package com.lastminuteTest.taxRate;

import com.lastminuteTest.product.Product;
import com.lastminuteTest.taxCalculator.TaxCalculatorStrategyInterface;

public interface CountryTaxRateInterface {

	public String getCountryPrefix();
	
	public void setCountryPrefix(String countryPrefix);
	
	public TaxCalculatorStrategyInterface getTaxCalculatorStrategy();
	
	public void setTaxCalculatorStrategy(TaxCalculatorStrategyInterface taxCalculator);
	
	public float calculateTax(Product product);
}
