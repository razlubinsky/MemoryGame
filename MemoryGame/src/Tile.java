import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Tile extends JLabel
{

	private static final long serialVersionUID = 1L;
	public static int width = 150;
	public static int height = 150;
	
	public static int[] blank = {0,0};
	public static int[] card1 = {1,0};
	public static int[] card2 = {2,0};
	public static int[] card3 = {3,0};
	public static int[] card4 = {4,0};
	public static int[] card5 = {5,0};
	public static int[] card6 = {6,0};
	public static int[] card7 = {7,0};
	public static int[] card8 = {8,0};
	public static int[] card9 = {9,0};
	
	public static BufferedImage tile_blank;
	public static BufferedImage tile_card1;
	public static BufferedImage tile_card2;
	public static BufferedImage tile_card3;
	public static BufferedImage tile_card4;
	public static BufferedImage tile_card5;
	public static BufferedImage tile_card6;
	public static BufferedImage tile_card7;
	public static BufferedImage tile_card8;
	public static BufferedImage tile_card9;
	
	public Tile()
	{
		try 
		{
			SpriteSheet sheet = new SpriteSheet(ImageIO.read(new File("res/tile_set.png")));
			
			Tile.tile_blank = sheet.crop(blank,width,height);
			Tile.tile_card1 = sheet.crop(card1,width,height);
			Tile.tile_card2 = sheet.crop(card2,width,height);
			Tile.tile_card3 = sheet.crop(card3,width,height);
			Tile.tile_card4 = sheet.crop(card4,width,height);
			Tile.tile_card5 = sheet.crop(card5,width,height);
			Tile.tile_card6 = sheet.crop(card6,width,height);
			Tile.tile_card7 = sheet.crop(card7,width,height);
			Tile.tile_card8 = sheet.crop(card8,width,height);
			Tile.tile_card9 = sheet.crop(card9,width,height);
						
		}
		catch(Exception e)
		{
			
		}
	}



	
	
}
