package com.lastminuteProblem.taxCalculator;

import com.lastminuteProblem.product.Product;
import com.lastminuteProblem.taxRate.TaxesType;

public interface TaxCalculatorStrategyInterface {

	public float calculateTaxes(TaxesType taxesType, Product product);
}
