package lib.render;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageFactory {
	
	private static HashMap<String, Image> images = new HashMap<>();
	
	private ImageFactory() { }
	
	
	public static Image getImage(String path) {
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
