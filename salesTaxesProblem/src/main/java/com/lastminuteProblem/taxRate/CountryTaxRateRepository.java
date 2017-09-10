package com.lastminuteProblem.taxRate;

import java.util.HashMap;

/**
 * Class used to store country tax rates for each country 
 * We can think to this class like a layer through which communications
 * to the database must pass  (this part is not realized, because not required)
 * HashMap used in order to have O(1) access time.
 * 
 * @author fabio
 *
 */
public class CountryTaxRateRepository implements CountryTaxRateRepositoryInterface {

	private static HashMap<String, CountryTaxRateInterface> countryTaxRates = new HashMap<String, CountryTaxRateInterface>(); 
	
	public CountryTaxRateInterface getTaxRate(String countryPrefix) {
	
		return CountryTaxRateRepository.countryTaxRates.get(countryPrefix);
	}

	public void insertCountryTaxRate(CountryTaxRateInterface countryTaxRate){
		
		CountryTaxRateRepository.countryTaxRates.put(countryTaxRate.getCountryPrefix(), countryTaxRate);		
	}
	
	public boolean deleteCountryTaxRate(CountryTaxRateInterface countryTaxRate){
		// TODO
		return true;
	}

}
