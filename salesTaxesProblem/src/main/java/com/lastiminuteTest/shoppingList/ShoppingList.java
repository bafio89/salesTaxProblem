package com.lastiminuteTest.shoppingList;

import java.util.ArrayList;

import com.lastminuteTest.product.Product;
import com.lastminuteTest.taxCalculator.CountryTaxStrategyRepositoryInterface;
import com.lastminuteTest.taxCalculator.TaxCalculatorStrategyInterface;
import com.lastminuteTest.taxRate.CountryTaxRateInterface;
import com.lastminuteTest.taxRate.CountryTaxRateRepositoryInterface;

/**
 * @author fabio
 *
 */
public class ShoppingList {
	
	float expense = 0;
	float totalTaxes = 0;
	
	CountryTaxRateRepositoryInterface taxRateRepository;

	CountryTaxStrategyRepositoryInterface taxStrategyRepository;
	
	public ShoppingList(CountryTaxRateRepositoryInterface taxRateRepository,
			CountryTaxStrategyRepositoryInterface taxStrategyRepository){
	
		this.taxRateRepository = taxRateRepository;
		this.taxStrategyRepository = taxStrategyRepository;
	}
	
	/**
	 * This method calculate the final bill starting from a product list.
	 * Starting from the countryPrefix the taxes rates are retived and consequently
	 * the strategy for calculate the taxes is choosen. 
	 * 
	 * @param productsList  list of product to be purchased
	 * @param countryPrefix  string with the country prefix ex: It, Ch, Fr. 
	 * @return String list with the final bill
	 */
	public String calculateBill(ArrayList<Product> productsList,String countryPrefix){

		String output = "";
		float finalPrice = 0;
		float taxes = 0;
		
		CountryTaxRateInterface countryTaxRate = taxRateRepository.getTaxRate(countryPrefix);
		
		TaxCalculatorStrategyInterface taxCalculatorStrategy = taxStrategyRepository.getTaxStrategy(countryPrefix);
				
		try{
			countryTaxRate.setTaxCalculatorStrategy(taxCalculatorStrategy);
		}catch (NullPointerException e){
			 System.err.println("Desidered country tax rate was not found");
			 e.printStackTrace();
			 return "Desidered country tax rate was not found";
		}	
		
		for (Product product : productsList) {
		
			try{
	        	taxes = countryTaxRate.calculateTax(product);
			    this.totalTaxes += taxes * product.getQuantity();
			}catch (NullPointerException e){
				 System.err.println("No strategy has been set");
				 e.printStackTrace();
				 return "No strategy has been set";
			}
			
			finalPrice = (product.getPrice() + taxes) * product.getQuantity();			
			this.expense += finalPrice;
			output += product.getQuantity() + " " + product.getName() + ": " + finalPrice + "\n";					 
		}
		
		output += "Sales Taxes: " + this.totalTaxes + "\n";
		output += "Total: " + this.expense;
		return output;
	}
	

}
