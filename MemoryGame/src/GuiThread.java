import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class GuiThread extends Thread 
{
	private int[] first_id;
	private int[] second_id;
	private MouseEvent e;
	private Block lastBlock;
	public GuiThread(int[] first_id,int[] second_id,MouseEvent e, Block lastBlock,int times)
	{
		this.first_id = first_id;
		this.second_id = second_id;
		this.e = e;
		this.lastBlock = lastBlock;
	}
	
    public void run() 
    {
    	final ReentrantLock reentrantLock = new ReentrantLock();
    	boolean flag = reentrantLock.tryLock();
    	if (flag)
    	{
    	
    		try 
    		{
    			GuiThread.sleep(900);
			} 
    		catch (InterruptedException e1) 
    		{
				e1.printStackTrace();
			}
    	
		
			if (Arrays.equals(first_id,second_id) && (!Arrays.equals(first_id, Tile.card9)))
			{
				
				int[] id = {9,0};
				if (!Arrays.equals(first_id,id))
				{
					((Block )e.getComponent()).setId(id);
					lastBlock.setId(id);
					Block.addToCounter();
					Board.checkVictory();
				}
			}
			else
			{
				int[] id = {0,0};
				id = ((Block )e.getComponent()).getId().clone();
				((Block )e.getComponent()).setId(Tile.blank);
				((Block )e.getComponent()).render();
				((Block )e.getComponent()).setId(id);
				id = lastBlock.getId().clone();
				lastBlock.setId(Tile.blank);
				lastBlock.render();
				lastBlock.setId(id);
			}
    	}
    	Block.setTimes(1);
    	reentrantLock.unlock();
    }


}
