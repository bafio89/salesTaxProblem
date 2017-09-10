package com.lastminuteProblem.shoppingList;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.lastminuteProblem.product.Product;
import com.lastminuteProblem.shoppingList.ShoppingList;
import com.lastminuteProblem.taxCalculator.CountryTaxStrategyRepository;
import com.lastminuteProblem.taxCalculator.CountryTaxStrategyRepositoryInterface;
import com.lastminuteProblem.taxCalculator.TaxCalculatorStandardStrategy;
import com.lastminuteProblem.taxRate.CountryTaxRate;
import com.lastminuteProblem.taxRate.CountryTaxRateRepository;
import com.lastminuteProblem.taxRate.CountryTaxRateRepositoryInterface;
import com.lastminuteProblem.taxRate.StandardTaxesType;

import junit.framework.TestCase;

public class ShoppingListTest extends TestCase{
		
	ShoppingList shoppingList;
	TaxCalculatorStandardStrategy taxCalculatorStrategy;
	CountryTaxStrategyRepositoryInterface countryTaxStrategyRepository;
	CountryTaxRateRepositoryInterface countryTaxRateRepository; 
	CountryTaxRate countryTaxRateCh;
	CountryTaxRate countryTaxRateSt;
	StandardTaxesType baseTaxesType;
	
	public void setUp(){
		this.baseTaxesType = new StandardTaxesType(5, 10);
		this.countryTaxRateSt = new CountryTaxRate("St", this.baseTaxesType);
		this.countryTaxRateCh = new CountryTaxRate("Ch", this.baseTaxesType);
		this.countryTaxStrategyRepository = new CountryTaxStrategyRepository();
		
		this.taxCalculatorStrategy = new TaxCalculatorStandardStrategy();
		this.countryTaxStrategyRepository.insertTaxStrategy("St", taxCalculatorStrategy);
		
		this.countryTaxRateRepository = new CountryTaxRateRepository();
		this.countryTaxRateRepository.insertCountryTaxRate(countryTaxRateSt);
						
		this.shoppingList = new ShoppingList(this.countryTaxRateRepository, this.countryTaxStrategyRepository);
		
		Product book = new Product(1, "book", 12.49f, true, false); 
		Product musicCD = new Product(1, "music CD", 14.99f, false, false); 
		Product choccolateBar = new Product(1, "chocolate bar", 0.85f, true, false); 
				
	}
	
	public void testCalculateBillWithNosettedCountryTaxRate(){
		
		ArrayList<Product> productsList1 = new ArrayList<Product>();
		
		assertEquals("Desidered country tax rate was not found", this.shoppingList.calculateBill(productsList1, "It"));
	}

	public void testCalculateBillWithNoSettedTaxCalculatorStrategy(){
		ArrayList<Product> productsList1 = new ArrayList<Product>();
		Product book = new Product(1, "book", 12.49f, true, false); 
		productsList1.add(book);
		
		this.countryTaxRateRepository.insertCountryTaxRate(countryTaxRateCh);
		
		assertEquals("No strategy has been set", this.shoppingList.calculateBill(productsList1, "Ch"));
	}
	
	public void testCalculateBillWithFirstInput(){
		
		ArrayList<Product> productsList1 = new ArrayList<Product>();
		Product book = new Product(1, "book", 12.49f, true, false); 
		Product musicCD = new Product(1, "music CD", 14.99f, false, false); 
		Product choccolateBar = new Product(1, "chocolate bar", 0.85f, true, false); 
			
		productsList1.add(book);		
		productsList1.add(musicCD);		
		productsList1.add(choccolateBar);
		
		assertEquals( "1 book: 12.49\n" + 
				      "1 music CD: 16.49\n" + 
					  "1 chocolate bar: 0.85\n" +
				      "Sales Taxes: 1.5\n" +
					  "Total: 29.83", this.shoppingList.calculateBill(productsList1, "St"));
	}
	
	
	public void testCalculateBillWithsecondInput(){
		
		ArrayList<Product> productsList2 = new ArrayList<Product>();
		Product boxOfChocolate = new Product(1, "imported box of chocolate", 10, true, true );
		Product bottleOfPerfume = new Product(1,"imported bottle of perfume", 47.50f, false, true );		
				
		productsList2.add(boxOfChocolate);
		productsList2.add(bottleOfPerfume);
		
		assertEquals( "1 imported box of chocolate: 10.5\n" +
					  "1 imported bottle of perfume: 54.65\n"+
					  "Sales Taxes: 7.65\n"+
					  "Total: 65.15", this.shoppingList.calculateBill(productsList2, "St"));
	}

	public void testCalculateBillWithThirdInput(){
		ArrayList<Product> productsList3 = new  ArrayList<Product>();
		Product importedBottleOfPerfume = new Product(1,"imported bottle of perfume", 27.99f, false, true );
		Product bottleOfPerfume = new Product(1,"bottle of perfume", 18.99f, false, false );
		Product headachePill = new Product(1,"packet of headache pills", 9.75f, true, false );
		Product importedChocolate = new Product(1,"imported box of chocolates", 11.25f, true, true );
		
		productsList3.add(importedBottleOfPerfume);
		productsList3.add(bottleOfPerfume);
		productsList3.add(headachePill);
		productsList3.add(importedChocolate);
		
		assertEquals( "1 imported bottle of perfume: 32.19\n" +
				  	  "1 bottle of perfume: 20.89\n"+
				  	  "1 packet of headache pills: 9.75\n"+
				  	  "1 imported box of chocolates: 11.85\n"+
				      "Sales Taxes: 6.7\n"+
				      "Total: 74.68", this.shoppingList.calculateBill(productsList3, "St"));
	}
	
	
}	
