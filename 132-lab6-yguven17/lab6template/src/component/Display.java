package component;

public class Display extends Component {
	private int width;
	private int height;
	private String resolution;
	private final double productionCostPerPixel = 0.0001;

	public Display(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double productionCost() {
		return productionCostPerPixel * getWidth() * getHeight();
	}

	@Override
	public double profitRate() {
		return 0.25;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String toString() {
		return "width=" + getWidth() + ", height=" + getHeight() + ", resolution=" + getResolution()
				+ ", productionCostPerPixel=" + productionCostPerPixel + ", productionCost="
				+ String.format("%.2f", productionCost()) + ", price=" + String.format("%.2f", price());
	}

}