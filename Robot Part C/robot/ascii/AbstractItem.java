package robot.ascii;

import com.googlecode.lanterna.terminal.Terminal;

//Zitao Zheng S3637675
public abstract class AbstractItem implements Drawable 
{
	private int column;
	private int item_height;
	private int bottomPosition;
	private char itemSymbol;
	
	public AbstractItem(int item_height, int column, int bottomPosition, char itemSymbol) 
	{
		super();
		this.item_height = item_height;
		this.column = column;
		this.bottomPosition = bottomPosition;
		this.itemSymbol = itemSymbol;
	}
	
	public int getItem_height() 
	{
		return item_height;
	}
	
	public int getColumn() 
	{
		return column;
	}

	public int getBottomPosition() 
	{
		return bottomPosition;
	}

	public void setColumn(int column) 
	{
		this.column = column;
	}
	
	public void setBottomPosition(int bottomPosition) 
	{
		this.bottomPosition = bottomPosition;
	}

	@Override
	public void draw(Terminal terminal)
	{
		// (0 index for terminal)
		int maxRow = terminal.getTerminalSize().getRows() - 1;
		
		// draw an item of height "item_height" in the specific column on the specific "bottomPosition"
		for (int rowPos = maxRow - bottomPosition; rowPos > maxRow - bottomPosition - item_height; rowPos--)
		{
			terminal.moveCursor(column, rowPos);
			terminal.putCharacter(itemSymbol);
		}
	}
}
