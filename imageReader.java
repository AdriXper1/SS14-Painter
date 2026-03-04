import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class imageReader {
	public static String readImage (File file)
	{

		String toReturn = "";
		
		BufferedImage image;
		
		try
		{
			image = ImageIO.read(file);

			int width = image.getWidth();
			int height = image.getHeight();

			if (width > 19)
			{
				BufferedImage resized = new BufferedImage(19, (int)(height * (19.0/width)), image.getType());
				
				Graphics2D g = resized.createGraphics();
				g.drawImage(image, 0, 0, 19, (int)(height * 19.0/width), null);
				g.dispose();

				image = resized;
			}

			width = image.getWidth();
			height = image.getHeight();

			for (int cpty = 0; cpty < height; cpty++)
			{
				for (int cptx = 0; cptx < width; cptx++)
				{
					int pixel = image.getRGB(cptx,cpty);
					
					int a = (pixel >> 24) & 0xff;
					
					int r = (pixel >> 16) & 0xff;
					
					int g = (pixel >> 8) & 0xff;

					int b = pixel & 0xff;

					toReturn += String.format("[color=#%02x%02x%02x]██", r, g, b);
				}
				toReturn += "\n";
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return toReturn;
	}
}
