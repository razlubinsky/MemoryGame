import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Tile extends JLabel
{

	private static final long serialVersionUID = 1L;
	private static int width = 150;
	private static int height = 150;
	private static int[] card = new int[10];
		
	public static BufferedImage[] tile = new BufferedImage[10];
	
	public Tile()
	{
		try 
		{
			initCard();
			SpriteSheet sheet = new SpriteSheet(ImageIO.read(new File("res/tile_set.png")));
			for (int i = 0; i<10; i++)
			Tile.tile[i] = sheet.crop(card[i],width,height);
						
		}
		catch(Exception e)
		{
			
		}
	}
	public static int getTileWidth()
	{
		return width;
	}
	public static int getTileHeight()
	{
		return height;
	}
	public static int getCard(int index)
	{
		return card[index];
	}
	public void setCard(int index,int value)
	{
		card[index] = value;
	}
	public void initCard()
	{
		for(int i = 0; i<10; i++)
			setCard(i,i);
	}	
}
