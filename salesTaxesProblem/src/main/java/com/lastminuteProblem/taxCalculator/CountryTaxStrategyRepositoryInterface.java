package com.lastminuteProblem.taxCalculator;


public interface CountryTaxStrategyRepositoryInterface {

	public TaxCalculatorStrategyInterface getTaxStrategy(String countryPrefix); 
	
	public void insertTaxStrategy(String countryPrefix, TaxCalculatorStrategyInterface countryTaxCalculatorStrategy);
	
	public boolean deleteTaxStrategy(String countryPrefix);
		
}
