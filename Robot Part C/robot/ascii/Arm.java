package robot.ascii;

import com.googlecode.lanterna.terminal.Terminal;

//Zitao Zheng S3637675
public class Arm implements Drawable
{
	private int height;
	private int width;
	private int depth;
	
	private Block pickedBlock;
	
	public Arm(int height, int width, int depth)
	{
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

	public int getHeight() 
	{
		return height;
	}

	public int getWidth() 
	{
		return width;
	}

	public int getDepth() 
	{
		return depth;
	}

	@Override
	public void draw(Terminal terminal)
	{
		int maxRow = terminal.getTerminalSize().getRows() - 1;
		
		terminal.applyForegroundColor(Terminal.Color.WHITE);
		
		// draw arm1
		// arm1 always in column0
		for (int rowPos = maxRow; rowPos > maxRow - height; rowPos--)
		{
			terminal.moveCursor(0, rowPos);
			terminal.putCharacter('|');
		}
		
		// draw arm2
		for (int colPos = 0; colPos < width; colPos++)
		{
			terminal.moveCursor(colPos, maxRow - (height - 1));
			terminal.putCharacter('-');
		}
		
		// draw arm3
		// in order to reproduce the behavior shown in the video, 
		//the height and depth should be adjusted
		for (int rowPos = maxRow - (height - 1); rowPos < maxRow - ((height - 1) - (depth + 1)); rowPos++)
		{
			terminal.moveCursor(width, rowPos); 
			terminal.putCharacter('|');
		}
	}
	
	// record the block that the arm picks up
	public void setPickedBlock(Block pickedBlock)
	{
		this.pickedBlock = pickedBlock;
	}
	
	// if pickedBlock is not null, the arm is catching a block
	// and the specific method would call the corresponding method in the Block class to move the picked block
	public void up()
	{
		height++;
		if (pickedBlock != null)
			pickedBlock.raise();
	}
	
	public void down()
	{
		height--;
		if (pickedBlock != null)
			pickedBlock.lower();
	}

	public void contract()
	{
		width--;
		if (pickedBlock != null)
			pickedBlock.contract();
	}

	public void extend()
	{
		width++;
		if (pickedBlock != null)
			pickedBlock.extend();
	}

	public void lower()
	{
		depth++;
		if (pickedBlock != null)
			pickedBlock.lower();
	}

	public void raise()
	{
		depth--;
		if (pickedBlock != null)
			pickedBlock.raise();
	}
}
