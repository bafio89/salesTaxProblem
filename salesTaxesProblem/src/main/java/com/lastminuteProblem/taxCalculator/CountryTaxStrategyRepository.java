package com.lastminuteProblem.taxCalculator;

import java.util.HashMap;

/**
 * Class used to store country tax strategy for each country
 * We can think to this class like a layer through which communications 
 * must pass to the database (this part is not realized, because not required)
 * HashMap used in order to have O(1) access time.
 *
 * @author fabio
 *
 */
public class CountryTaxStrategyRepository implements CountryTaxStrategyRepositoryInterface {

	private static HashMap<String, TaxCalculatorStrategyInterface> countryTaxStrategy = new HashMap<String, TaxCalculatorStrategyInterface>(); 
	
	public TaxCalculatorStrategyInterface getTaxStrategy(String countryPrefix) {

		return CountryTaxStrategyRepository.countryTaxStrategy.get(countryPrefix);
	}

	public void insertTaxStrategy(String countryPrefix, TaxCalculatorStrategyInterface countryTaxCalculatorStrategy) {

		CountryTaxStrategyRepository.countryTaxStrategy.put(countryPrefix, countryTaxCalculatorStrategy);			
	}

	public boolean deleteTaxStrategy(String countryPrefix) {
		// TODO Auto-generated method stub
		return false;
	}

}
