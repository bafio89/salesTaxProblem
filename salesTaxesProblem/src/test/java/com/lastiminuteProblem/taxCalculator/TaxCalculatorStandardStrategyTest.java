package com.lastiminuteProblem.taxCalculator;

import com.lastminuteProblem.product.Product;
import com.lastminuteProblem.taxCalculator.TaxCalculatorStandardStrategy;
import com.lastminuteProblem.taxRate.StandardTaxesType;

import junit.framework.TestCase;

public class TaxCalculatorStandardStrategyTest extends TestCase {

	TaxCalculatorStandardStrategy taxCalculator;
	StandardTaxesType baseTaxesType;
	
	public void setUp(){
		
		taxCalculator = new TaxCalculatorStandardStrategy();
		baseTaxesType = new StandardTaxesType(5, 10);
 
	}
	
	public void testCalculateTaxesWithBaseAndImportedTaxes(){

		Product book = new Product(1, "imported book", 15.12f, false, true);
		this.taxCalculator.calculateTaxes(this.baseTaxesType, book);
		assertEquals(2.3f, this.taxCalculator.calculateTaxes(this.baseTaxesType, book));
	}
	
	public void testCalculateTaxesWithBaseTax(){
		Product book = new Product(1, "imported book", 15.12f, false, false);
		this.taxCalculator.calculateTaxes(this.baseTaxesType, book);
		assertEquals(1.55f, this.taxCalculator.calculateTaxes(this.baseTaxesType, book));
	}
	
	public void testCalculateTaxesWithImportedTax(){
		Product book = new Product(1, "imported book", 15.12f, true, true);
		this.taxCalculator.calculateTaxes(this.baseTaxesType, book);
		assertEquals(0.75f, this.taxCalculator.calculateTaxes(this.baseTaxesType, book));
	}
}
