package computer;

import component.CPU;
import component.Display;

public class Laptop extends Computer {

	private int cameraCost;

	public Laptop(CPU cpu, Display display, String modelName, int cameraCost) {
		this.cpu = cpu;
		this.display = display;
		this.modelName = modelName;
		this.cameraCost = cameraCost;
	}

	@Override
	public boolean isWearable() {
		return false;
	}

	@Override
	public boolean isPortable() {
		return true;
	}

	@Override
	public double price() {
		return super.price() + cameraCost;
	}

	public int getCameraCost() {
		return cameraCost;
	}

	public void setCameraCost(int cameraCost) {
		this.cameraCost = cameraCost;
	}

	public String toString() {
		return "Laptop:\n- cameraCost=" + getCameraCost() + "\n- modelName=" + getModelName() + "\n- cpu=" + getCpu()
				+ "\n- display=" + getDisplay() + "\n- price=" + String.format("%.2f", price());
	}
}