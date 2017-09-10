package com.lastminuteProblem.taxRate;

public class StandardTaxesType extends TaxesType{
	
	float importedRateTax = 0;
	
	public StandardTaxesType(float importedRateTax, float baseRateTax){
		super(baseRateTax);
		this.importedRateTax = importedRateTax;
	}
	
	public float getImportedRateTax() {
		return importedRateTax;
	}

	public void setImportedRateTax(float importedRateTax) {
		this.importedRateTax = importedRateTax;
	}
	
	
}
