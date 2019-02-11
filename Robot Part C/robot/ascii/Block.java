package robot.ascii;

import com.googlecode.lanterna.terminal.Terminal;

import control.Control;

//Zitao Zheng S3637675
public class Block extends AbstractItem
{
	public Block(int block_height, int column, int bottomPosition)
	{
		super(block_height, column, bottomPosition, '+');
	}
	
	@Override
	public void draw(Terminal terminal)
	{
		// yellow for block 1, red for block 2, blue for block 3
		if (super.getItem_height() == Control.MIN_BLOCK_HEIGHT)
			terminal.applyForegroundColor(Terminal.Color.YELLOW);
		else if (super.getItem_height() == Control.MAX_BLOCK_HEIGHT)
			terminal.applyForegroundColor(Terminal.Color.BLUE);
		else
			terminal.applyForegroundColor(Terminal.Color.RED);
		
		// draw an block of height "block_height" in the specific column on the specific "bottomPosition"
		super.draw(terminal);
	}

	// these methods are for moving the blocking picked by the arm
	public void contract()
	{
		super.setColumn(super.getColumn() - 1);
	}

	public void extend()
	{
		super.setColumn(super.getColumn() + 1);
	}

	public void lower()
	{
		super.setBottomPosition(super.getBottomPosition() - 1);
	}

	public void raise()
	{
		super.setBottomPosition(super.getBottomPosition() + 1);
	}
}
