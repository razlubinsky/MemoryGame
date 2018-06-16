import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Block extends JButton implements MouseListener,Runnable
{
	
	private static final long serialVersionUID = 1L;
	private static int times = 1;
	private static int first_id = -1; 
	private static int second_id = -1;
	private static int counter = 0;
	
	private int id = 0;
	private static Block lastBlock = new Block(first_id);
	
	public Block()
	{
		
	}
	public static int getCounter()
	{
		return counter;
	}
	//check that after 8 pairs we finish the game
	public static void addToCounter()
	{
		counter++;
	}
	//add mouse listener to each block
	public Block(int id)
	{
		this.setId(id);
		addMouseListener(this);
		
	}
	//checks that after two flips of cards its the end of the turn
	public int getTimes() 
	{
		return times;
	}
	public static void setTimes(int numOfTimes) 
	{
		times = numOfTimes;
	}
	public int getId()
	{
		return this.id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void render()
	{
		if (!Board.getIsVictory() && this.id != 9)
		{
			this.setIcon(new ImageIcon(Tile.tile[this.id]));
		}
		//when finish the game change the cards to card9
		else
		{
			if(this.id == Tile.getCard(9))
			{
				this.setIcon(new ImageIcon(Tile.tile[this.id]));
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{	
		//first card is open
		if (times == 1)
		{
			if ((this.getId() != Tile.getCard(9)))
			{
				lastBlock = ((Block )e.getComponent());
				this.render();
				first_id = this.getId();
				times++;
			}
		}
		//second card is open
		else if (times == 2)
		{
			//check the player didn't click the same card or one that is already open
			if (this != lastBlock && ((this.getId() != Tile.getCard(9))))
			{
				times = 3;
				this.render();
				second_id = this.getId();
				//need another thread to do the update of the Gui
				GuiThread thread = new GuiThread(first_id,second_id,e,lastBlock,times);
				thread.start();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() 
	{
		
		(new Thread(new Block())).start();
		
	}
}	
	
		
		


	
