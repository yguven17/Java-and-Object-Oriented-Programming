package component;

import main.SaleItem;

public abstract class Component implements SaleItem {

	public abstract double productionCost();

	public abstract double profitRate();

	public double price() {
		{
			return productionCost() * (1 + profitRate());
		}
	}

}