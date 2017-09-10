package com.lastminuteProblem.taxRate;

import com.lastminuteProblem.product.Product;
import com.lastminuteProblem.taxCalculator.TaxCalculatorStrategyInterface;

public interface CountryTaxRateInterface {

	public String getCountryPrefix();
	
	public void setCountryPrefix(String countryPrefix);
	
	public TaxCalculatorStrategyInterface getTaxCalculatorStrategy();
	
	public void setTaxCalculatorStrategy(TaxCalculatorStrategyInterface taxCalculator);
	
	public float calculateTax(Product product);
}
