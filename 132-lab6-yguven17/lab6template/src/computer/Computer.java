package computer;

import component.Component;

import main.SaleItem;

public abstract class Computer implements SaleItem {
	protected String modelName;
	protected Component cpu;
	protected Component display;

	public double price() {
		return cpu.price() + display.price();
	}

	public abstract boolean isWearable();

	public abstract boolean isPortable();

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Component getCpu() {
		return cpu;
	}

	public void setCpu(Component cpu) {
		this.cpu = cpu;
	}

	public Component getDisplay() {
		return display;
	}

	public void setDisplay(Component display) {
		this.display = display;
	}

}