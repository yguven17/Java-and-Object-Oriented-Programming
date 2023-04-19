package component;

public class CPU extends Component {

	private double frequency;
	private double numTransistors;

	public CPU(double frequency, double numTransistors) {
		this.frequency = frequency;
		this.numTransistors = numTransistors;
	}

	@Override
	public double productionCost() {
		return getFrequency() * 50;
	}

	@Override
	public double profitRate() {
		if (getFrequency() > 2.4) {
			return 0.3;
		}
		return 0.2;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public double getNumTransistors() {
		return numTransistors;
	}

	public void setNumTransistors(double numTransistors) {
		this.numTransistors = numTransistors;
	}

	public String toString() {
		return "frequency=" + getFrequency() + ", numTransistors=" + getNumTransistors() + ", price="
				+ String.format("%.2f", price());
	}

}