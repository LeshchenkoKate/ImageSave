import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageWindow extends Frame {

	static int[][] array;
	
	static BufferedImage myImage;

	public void paint(Graphics g) {

		g.drawImage(myImage, 0, 0, null);
		

	}

	ImageWindow() {

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				setSize(70 * (array[i].length + 2), 30 * (array.length + 2));
				myImage = new BufferedImage(70 * (array[i].length + 2), 30 * (array.length + 2),
						BufferedImage.TYPE_INT_BGR);
				
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				Graphics grimg = myImage.getGraphics();
				grimg.setColor(Color.white);
				grimg.fillRect(0, 0, 70 * (array[i].length + 2), 30 * (array.length + 2));
				Color myColor = new Color(array[i][j], 0, 0);
				grimg.setColor(myColor);
				grimg.fillRect(70 * (j + 1), 30 * (i + 1), 70, 15);
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				Color myColor = new Color(array[i][j], 0, 0);
				Graphics grimg = myImage.getGraphics();
				grimg.setColor(myColor);
				grimg.fillRect(70 * (j + 1), 30 * (i + 1), 70, 15);
			}

		}

	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}

	static void saveImage() throws IOException {

		try {
		    File outputfile = new File("Image.jpg");
		    ImageIO.write(myImage, "jpg", outputfile);
		    System.out.println("Saved");
		    System.out.println("File in: " + outputfile.getAbsolutePath());
		}  catch (IOException e) { 
	            System.out.println("Image could not be read");
	            System.exit(1);
	        }
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of column:");
		int column, row;
		Scanner in = new Scanner(System.in);
		column = in.nextInt();
		System.out.println("Enter the number of row:");
		row = in.nextInt();
		array = new int[row][column];
		System.out.println("Enter an array:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				array[i][j] = in.nextInt();
			}
		}

		ImageWindow myWindow = new ImageWindow();
		saveImage();
		System.exit(2);
			
	}
}
