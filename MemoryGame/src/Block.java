import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Block extends JButton implements MouseListener,Runnable
{
	
	private static final long serialVersionUID = 1L;
	private static int times = 1;
	private static int[] first_id = {-1,-1}; 
	private static int[] second_id = {-1,-1};
	private static int counter = 0;
	
	public int[] id = {0,0};
	private static Block lastBlock = new Block(first_id);
	
	public Block()
	{
		
	}
	public static int getCounter()
	{
		return counter;
	}
	public static void addToCounter()
	{
		counter++;
	}
	
	public Block(int[] id)
	{
		this.setId(id);
		addMouseListener(this);
		
	}
	public int getTimes() 
	{
		return times;
	}

	public static void setTimes(int numOfTimes) 
	{
		times = numOfTimes;
	}



	public int[] getId()
	{
		return this.id;
	}
	public void setId(int[] id)
	{
		this.id = id.clone();
	}
	
	public void render()
	{
		if (!Board.isVictory)
		{
			if(Arrays.equals(this.id, Tile.blank))
			{
				this.setIcon(new ImageIcon(Tile.tile_blank));
			}
			if(Arrays.equals(this.id, Tile.card1))
			{
				this.setIcon(new ImageIcon(Tile.tile_card1));
			}
			if(Arrays.equals(this.id, Tile.card2))
			{
				this.setIcon(new ImageIcon(Tile.tile_card2));
			}
			if(Arrays.equals(this.id, Tile.card3))
			{
				this.setIcon(new ImageIcon(Tile.tile_card3));
			}
			if(Arrays.equals(this.id, Tile.card4))
			{
				this.setIcon(new ImageIcon(Tile.tile_card4));
			}
			if(Arrays.equals(this.id, Tile.card5) )
			{
				this.setIcon(new ImageIcon(Tile.tile_card5));
			}
			if(Arrays.equals(this.id, Tile.card6))
			{
				this.setIcon(new ImageIcon(Tile.tile_card6));
			}
			if(Arrays.equals(this.id, Tile.card7))
			{
				this.setIcon(new ImageIcon(Tile.tile_card7));
			}
			if(Arrays.equals(this.id, Tile.card8))
			{
				this.setIcon(new ImageIcon(Tile.tile_card8));
			}
		}
		else
		{
			if(Arrays.equals(this.id, Tile.card9))
			{
				this.setIcon(new ImageIcon(Tile.tile_card9));
			}
		}
	}

	public void flipCards(int[] one, int[] two)
	{
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{	
		if (times == 1)
		{
			if (!Arrays.equals(this.getId(), Tile.card9))
			{
				lastBlock = ((Block )e.getComponent());
				this.render();
				first_id = this.getId().clone();
				times++;
			}
		}
		else if (times == 2)
		{
			if (this != lastBlock && (!Arrays.equals(this.getId(), Tile.card9)))
			{
				times = 3;
				this.render();
				second_id = this.getId().clone();
				
				
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
	
		
		


	
