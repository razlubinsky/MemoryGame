import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JFrame;

public class Board extends JFrame implements Runnable
{
	
	private static final long serialVersionUID = 1L;
	private static int ind_x=4;
	private static int ind_y=4;
	
	public int id = 0;
	public static Block[][] block = new Block[ind_x][ind_y];
	public static Image screen;
	public static Dimension size = new Dimension(ind_x*Tile.width +10 ,ind_y*Tile.height +10);
	public static boolean isVictory = false;
	public Board()
	{
		
		this.setSize(size.width,size.height);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension dim = tk.getScreenSize();
		
		int xPos= (dim.width /2 ) - (this.getWidth() /2);
		int yPos= (dim.height /2 ) - (this.getHeight() /2);
			
		this.setLocation(xPos, yPos);	
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Memory game");
		this.setVisible(true);
		
		GridLayout grid = new GridLayout(ind_x, ind_y);
		this.setLayout(grid);

		for (int x=0; x<ind_x;x++)
		{
			for(int y=0;y<ind_y;y++)
			{
				block[x][y] = new Block(id);
				this.add(block[x][y]);
			}
		}
		generateLevel();
	}
	//check if all the 8 pairs are open
	public static void checkVictory()
	{
		if (Block.getCounter() == ((Board.getInd_x())*(Board.getInd_Y()))/2)
		{
			setVictory();
			victory();
		}
			
	}
	public static void setVictory()
	{
		Board.isVictory = true;
	}
	//open all the cards as card9
	public static void victory()
	{
		for (int x=0;x<ind_x;x++)
		{
			for(int y=0; y<ind_y; y++)
			{
				{
					block[x][y].setId(Tile.getCard(9));
					block[x][y].render();
				}
			}
		}
	}
	public static int getInd_x()
	{
		return ind_x;
	}
	public static int getInd_Y()
	{
		return ind_y;
	}
	//random the cards 
	public void shuffleDeck()
	{
		int cardPos = 1;
		int x;
		int y;
		int secondCard = 0;
		Random rand = new Random();
		while (cardPos<=8)
		{
			x = rand.nextInt(4);
			y = rand.nextInt(4);
			if (block[x][y].getId() == Tile.getCard(0))
			{
				this.id=cardPos;
				block[x][y].setId(this.id);
				secondCard++;
				if (secondCard == 2)
				{
					secondCard = 0;
					cardPos++;
				}
			}
		}
	}
	public void start()
	{
		new Tile(); 
		new Thread(this).start();
	}
	//all cards at start are closed
	public void generateLevel()
	{
		for (int x=0; x<ind_x;x++)
		{
			for(int y=0; y<ind_y;y++)
			{
				{
					block[x][y].setId(Tile.getCard(0));
				}
			}
		}
	}
	@Override
	public void run() 
	{
		screen = createVolatileImage(size.width, size.height);
		render();
		this.shuffleDeck();
	}
	
	public void render(Graphics g)
	{
		for (int x=0; x<ind_x;x++)
		{
			for(int y=0;y<ind_y;y++)
			{
				block[x][y].render(); 
			}
		}
		
	}
	public void render()
	{
		Graphics g = screen.getGraphics();
		this.render(g);
		
		g = getGraphics();
		g.drawImage(screen, 5, 30, size.width , size.height , 0, 0, size.width , size.height, null);
	}
    public static void main(String args[]) 
    {
		Board board = new Board();
		board.start();
        
    }
}
