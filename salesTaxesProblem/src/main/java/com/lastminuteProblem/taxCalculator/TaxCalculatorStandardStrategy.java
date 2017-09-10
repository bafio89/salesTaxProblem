package com.lastminuteProblem.taxCalculator;

import com.lastminuteProblem.product.Product;
import com.lastminuteProblem.taxRate.StandardTaxesType;
import com.lastminuteProblem.taxRate.TaxesType;

/**
 * This class implements a standard strategy to calculate taxes
 * @author fabio
 *
 */
public class TaxCalculatorStandardStrategy implements TaxCalculatorStrategyInterface {
	
	/**
	 * Method that turns the tax amount to apply to the price
	 * 
	 * @param taxesType class containing taxes rate to apply
	 * @param product class containing the product
	 * @return the taxes value to add to the price of the product
	 */
	public float calculateTaxes(TaxesType taxesType, Product product) {
		
		float taxes = 0;
		StandardTaxesType baseTaxesType = (StandardTaxesType)taxesType;
		
		if(!product.isBaseTaxFree()){
			taxes += baseTaxesType.getBaseRateTax();
		}
		
		if(product.isImported()){
			taxes += baseTaxesType.getImportedRateTax();
		}
		
		return this.approximate(product.getPrice(), taxes);

	}
	
	/**
	 * This method performs the approximation
	 * according to the rule: np/100 rounded up to the nearest 0.05
	 * I decide to manipulate long in order to avoid undesirable approximations 
	 */	
	private float approximate(float price,float taxes){
		
		long priceLong = (long)(price * 100);
		
		long partialResult = (long)(( priceLong * taxes ) / 100);
		
		long approximateResult = ((partialResult + 4) / 5) * 5; 
		
		return (float)approximateResult / 100;
	}

}
