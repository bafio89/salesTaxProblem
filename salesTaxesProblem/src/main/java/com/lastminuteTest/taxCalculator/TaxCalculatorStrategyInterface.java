package com.lastminuteTest.taxCalculator;

import com.lastminuteTest.product.Product;
import com.lastminuteTest.taxRate.TaxesType;

public interface TaxCalculatorStrategyInterface {

	public float calculateTaxes(TaxesType taxesType, Product product);
}
