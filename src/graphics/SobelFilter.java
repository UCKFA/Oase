package graphics;

import java.awt.image.BufferedImage;

public class SobelFilter {

	private static int[][] kernel = new int[][] { { 0, 1, 0 }, { 1, -4, 1 },
			{ 0, 1, 0 } };
	private static BufferedImage image;

	public static BufferedImage applyFilter(ImagePanel img) {

		image = img.getImage();
		
		for (int i = 1; i < img.getWidth()-2; i++){ 
			for (int j = 1; j < img.getHeight()-2; j++){ 
				
				System.out.println(applyLaPlace(i, j));
				break;
				//image.setRGB(i, j, applyLaPlace(i,j));
				
			}
		}
		return image;
	}
	
	public static int applyLaPlace(int x, int y) {
		int xn=x-1; 
		int yn=y-1;
		int px = 0;
		int val = 1;
		
		for (int ki = -1; ki <= 1; ki++) {
			for (int kj = -1; kj <= 1; kj++) {
			
				val = image.getRGB(xn, yn);
				px += val * kernel[ki+1][kj+1];
				
				yn++;
			}
			yn=y-1;
			xn++;
		}
	
		return px;
	}
}
