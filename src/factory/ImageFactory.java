package factory;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * This factory load an image from the HD if not already loaded.
 *
 */
public class ImageFactory {

	private static HashMap<String, Image> images = new HashMap<>();
	
	public static Image loadImage(String path) {
		if(!images.containsKey(path)) {
			try {
				Image img = ImageIO.read(new File(path));
				images.put(path, img);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return images.get(path);
	}
	
}
