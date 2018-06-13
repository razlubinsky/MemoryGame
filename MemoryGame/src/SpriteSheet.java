import java.awt.image.BufferedImage;

public class SpriteSheet 
{
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}
	//takes the image from the sprite sheet according to the id
	public BufferedImage crop(int id[], int width, int height)
	{
		return sheet.getSubimage(id[0]*width, id[1]*height, width, height);
	}

}
