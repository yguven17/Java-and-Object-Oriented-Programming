package computer;

import component.CPU;
import component.Display;

public class Desktop extends Computer {

	public Desktop(CPU cpu, Display display, String modelName) {
		this.cpu= cpu;
		this.display= display;
		this.modelName= modelName;
		
	}

	public String toString() {
		return "Desktop:\n- modelName=" + getModelName() + "\n- Cpu=" + getCpu() + "\n- Display=" + getDisplay()
				+ "\n- price=" + String.format("%.2f", price());
	}

	@Override
	public boolean isWearable() {
		return false;
	}

	@Override
	public boolean isPortable() {
		return false;
	}

}