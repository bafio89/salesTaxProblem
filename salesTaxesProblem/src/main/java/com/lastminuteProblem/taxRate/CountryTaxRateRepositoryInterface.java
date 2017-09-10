package com.lastminuteProblem.taxRate;

public interface CountryTaxRateRepositoryInterface {
	
	public CountryTaxRateInterface getTaxRate(String countryPrefix); 
	
	public void insertCountryTaxRate(CountryTaxRateInterface countryTaxRate);
	
	public boolean deleteCountryTaxRate(CountryTaxRateInterface countryTaxRate);
	
}
