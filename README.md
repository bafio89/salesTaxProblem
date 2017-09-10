# salesTaxProblem


The problem posed few constraints about context and usage of the application.
For this reason I supposed the system could serve different systems among different country. 
With this in mind, I assumed that the taxes rates and round rules can change according to the country.
So the system, starting from ShoppingList class, takes in input the product list to be acquired and a country prefix (es. It, Ch, Fr, Sp) and according to this selects taxes rate and strategy to apply in order to calculate the taxes.
To achieve this, a strategy pattern was implemented.
To store tax rates and strategy to use I created the classes CountryTaxRateRepository and CountryTaxStrategyRepository.
We can think to this two Repositories class like a layer through which communications to the database must pass (this part is not realized, because not required). This two repositories class acting also like a cache, storing data in an HashMap, where key is the country Prefix. In this way we have O(1) complexity each time we need this informations.

After the system retrieve tax rates and strategy, can procede to calculate the taxes. 
The class that calculate the taxes in the way required by the problem is TaxCalculatorStandardStrategy. I choosed to call it Standard just because the problem doesn't talk about any country where this rules should be applied, but we can imagine a country name instead of 'Standard' (es. taxCalculatorItalyStrategy).
In order to comply to required round rule (np/100 rounded up to the nearest 0.05), it was necessary manipulate the number as long, instead as float or double. This in order to avoid undesired approximation performed by computer calculus limitations.

Finally the system constructs the final bill adding taxes and price in order to obtain final count and final taxes.
