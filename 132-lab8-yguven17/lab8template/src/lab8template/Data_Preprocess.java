pacjage lab8template;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Data_Preprocess {
	static int input2 = 0;

	public static void main(String[] args) throws IOException {

		processLabel();

	}

	public static void processLabel() throws IOException {

		Image image = new Image();
		int[] arr = new int[25];

		int counter1 = 0;
		int counter_2 = 0;

		try (Scanner input = new Scanner(Paths.get("labels.txt"))) {
			while (input.hasNextLine()) {
				try {

					boolean check = true;
					String line = input.nextLine().trim();
					char[] ch = line.toCharArray();

					
					String[] split = String.valueOf(ch).split(" ");

					if (split[0].equals("img_id:") || split[0].equals("img_iD:") || split[0].equals("img_Id:")
							|| split[0].equals("img_ID:") || split[0].equals("Img_id:") || split[0].equals("Img_iD:")
							|| split[0].equals("Img_Id:") || split[0].equals("Img_ID:") || split[0].equals("image_id:")
							|| split[0].equals("image_iD:") || split[0].equals("image_Id:")
							|| split[0].equals("image_ID:") || split[0].equals("Image_id:")
							|| split[0].equals("Image_iD:") || split[0].equals("Image_Id:")
							|| split[0].equals("Image_ID:")) {
						int valueofimage = Integer.parseInt(split[1]);
						if (valueofimage < 10000) {

						} 

					if (split[2].equals("Label:") || split[2].equals("label:")) {
						int label_value = Integer.parseInt(split[3]);
						if (label_value < 1000) {
						}

					
					
					for (int i = 0; i < split.length; i++) {

						if (split[i].equals("X1:") || split[i].equals("x1:") || split[i].equals("XMin:")
								|| split[i].equals("xMin:") || split[i].equals("Xmin:") || split[i].equals("xmin:")) {
							int x_min = Integer.parseInt(split[i + 1]);
							counter_2++;
							if (x_min < 10000) {
								counter_2++;
							}
						}

						if (split[i].equals("Y1:") || split[i].equals("y1:") || split[i].equals("YMin:")
								|| split[i].equals("yMin:") || split[i].equals("Ymin:") || split[i].equals("ymin:")) {
							int y_min = Integer.parseInt(split[i + 1]);
							if (y_min < 10000) {
								counter_2++;
							}
						}

						if (split[i].equals("X2:") || split[i].equals("x2:") || split[i].equals("XMax:")
								|| split[i].equals("xMax:") || split[i].equals("Xmax:") || split[i].equals("xmax:")) {
							counter_2++;
							int x_max = Integer.parseInt(split[i + 1]);
							if (x_max < 10000) {
								counter_2++;
							}
						}

						if (split[i].equals("Y2:") || split[i].equals("y2:") || split[i].equals("YMax:")
								|| split[i].equals("yMax:") || split[i].equals("Ymax:") || split[i].equals("ymax:")) {
							counter_2++;
							int y_max = Integer.parseInt(split[i + 1]);
							if (y_max < 10000) {
								counter_2++;
							}
						}

					}

					if (check) {
						for (int i = 0; i < split.length; i++) {
							System.out.print(split[i]);
						}
						System.out.println();

						counter1++;
						arr[counter1] = counter1;
					}
				

				catch (Exception e) {
					counter_2 = 0;

				}
			}
			image.setLabels(arr);

			System.out.println(image.toString());

		}

	}
}