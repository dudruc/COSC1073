package robot.ascii;

import robot.Robot;

import javax.swing.JFrame;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import control.Control;
import control.RobotControl;

//Robot Assignment for Programming 1 s1 2017
//ASCIIBot classes written by Caspar Ryan

//Zitao Zheng S3637675
public class ASCIIBot implements Robot
{
	// the Lanterna terminal
	private Terminal terminal;
	
	// for simplicity I do not do graceful exiting code so just use the eclipse STOP button to exit
	
	private Bar[] bars;
	private Block[] blocks;
	private Arm arm;
	
	public static void main(String[] args)
	{
		// instantiate ASCIIBot and run control()
		new RobotControl().control(new ASCIIBot(),null, null);
	}

	// the constructor initialises the Lanterna Terminal
	public ASCIIBot()
	{
		// create the terminal 20 rows, 15 columns
		terminal = TerminalFacade.createSwingTerminal(
				22, 14);

		// required by Lanterna framework to initialise
		terminal.enterPrivateMode();
		terminal.setCursorVisible(false);
		
		terminal.clearScreen();
		
		// set close operation so program with exit if "X" clicked
		if(terminal instanceof SwingTerminal)
		{
			((SwingTerminal) terminal).getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	@Override
	public void init(int[] barHeights, int[] blockHeights, int height,
			int width, int depth)
	{
		// in order to draw blocks, record the height of every column in an array before putting a bar or a block
		int[] columnHeights = new int [Control.FIRST_BAR_COLUMN + Control.MAX_BARS];
		
		bars = new Bar[barHeights.length];
		
		for(int i = 0; i < bars.length; i++)
		{
			// every bar object records its height and located column
			bars[i] = new Bar(barHeights[i], i + Control.FIRST_BAR_COLUMN);
			columnHeights[i + Control.FIRST_BAR_COLUMN - 1] += barHeights[i];
		}
		
		// delay 100 milliseconds for next "frame"
		delayAnimation(100);
		
		// do real code here ..
		blocks = new Block[blockHeights.length];
		
		// col is for helping put block 3 on the right position
		int blockCol = Control.FIRST_BAR_COLUMN;
		
		for(int i = 0; i < blocks.length; i++)
		{
			// every object records its height, located column and the height of located column
			if(blockHeights[i] != Control.MAX_BLOCK_HEIGHT)
			{
				blocks[i] = new Block(blockHeights[i], blockHeights[i], columnHeights[blockHeights[i] - 1]);
				columnHeights[blockHeights[i] - 1] += blockHeights[i];
			}
			else
			{
				blocks[i] = new Block(blockHeights[i], blockCol, columnHeights[blockCol - 1]);
				columnHeights[blockCol - 1] += blockHeights[i];
				blockCol++;
			}
		}
		
		delayAnimation(100);
		
		// record three segments of the arm
		arm = new Arm(height, width, depth);

		// draw all the thing at the correct starting position
		drawAll();
	}
	
	// pass the picked block to the arm
	@Override
	public void pick()
	{
		arm.setPickedBlock(findBlock(arm.getHeight(), arm.getWidth(), arm.getDepth()));
	}
	
	// set the pickedBlock null after dropping the block
	@Override
	public void drop()
	{
		arm.setPickedBlock(null);
	}

	@Override
	public void up()
	{
		arm.up();
		drawAll();
	}

	@Override
	public void down()
	{
		arm.down();
		drawAll();
	}

	@Override
	public void contract()
	{
		arm.contract();
		drawAll();
	}

	@Override
	public void extend()
	{
		arm.extend();
		drawAll();
	}

	@Override
	public void lower()
	{
		arm.lower();
		drawAll();
	}

	@Override
	public void raise()
	{
		arm.raise();
		drawAll();
	}
	
	// searching the block array to find the picked block from the height, width and depth of the arm
	public Block findBlock(int height, int width, int depth)
	{
		int block_height;

		int column = width;
		if (column < 3)
			block_height = column;
		else
			block_height = Control.MAX_BLOCK_HEIGHT;
		
		// adjust the data in order to reproduce the behavior in the video
		int bottomPosition = (height - 1) + 1 - (depth + 1) - block_height;
		
		for(int i = 0; i < blocks.length; i++)
		{
			if((blocks[i].getColumn() == column) && (blocks[i].getBottomPosition() == bottomPosition))
				return blocks[i];
		}
		return null;
	}
	
	// clean and redraw the entire screen after a robot movement command is issued every time
	public void drawAll()
	{
		terminal.clearScreen();
		for(int i = 0; i < bars.length; i++)
			bars[i].draw(terminal);
		for(int i = 0; i < blocks.length; i++)
			blocks[i].draw(terminal);
		arm.draw(terminal);
		delayAnimation(100);
	}

	// delay in ms
	private void delayAnimation(int ms)
	{
		try
		{
			Thread.sleep(ms);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
