package lab8template;

public class Image {
	
	int img_id;
	int num_objects; 
	
	int[]labels;
	
	int[]xmin;
	int[]xmax;
	
	int[]ymin;
	int[]ymax;
	
	
	public void addObject() {
		
	}
	
	public String toString() {
		return "deneme";
	}

	public int getImg_id() {
		return img_id;
	}

	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}

	public int getNum_objects() {
		return num_objects;
	}

	public void setNum_objects(int num_objects) {
		this.num_objects = num_objects;
	}

	public int[] getLabels() {
		return labels;
	}

	public void setLabels(int[] labels) {
		this.labels = labels;
	}

	public int[] getXmin() {
		return xmin;
	}

	public void setXmin(int[] xmin) {
		this.xmin = xmin;
	}

	public int[] getXmax() {
		return xmax;
	}

	public void setXmax(int[] xmax) {
		this.xmax = xmax;
	}

	public int[] getYmin() {
		return ymin;
	}

	public void setYmin(int[] ymin) {
		this.ymin = ymin;
	}

	public int[] getYmax() {
		return ymax;
	}

	public void setYmax(int[] ymax) {
		this.ymax = ymax;
	}
	
	
}